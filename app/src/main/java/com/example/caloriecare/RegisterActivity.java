package com.example.caloriecare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

//import com.example.caloriecare.R;
//import com.example.caloriecare.user.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button btnRegisterConfirm, btnRegisterCancel;
    private EditText editName, editEmail, editPassword;
    private ProgressBar progressBar;

    //private FirebaseAuth myAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        //myAuth = FirebaseAuth.getInstance();
        btnRegisterConfirm = (Button) findViewById(R.id.btn_register_register);
        btnRegisterCancel = (Button) findViewById(R.id.btn_reg_cancel);
        editName = (EditText) findViewById(R.id.edit_reg_name);
        editEmail = (EditText) findViewById(R.id.edit_reg_email);
        editPassword = (EditText) findViewById(R.id.edit_reg_password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnRegisterConfirm.setOnClickListener(this);
        btnRegisterCancel.setOnClickListener(this);

        btnRegisterCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                finish();
            }

        });
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_register_register:
                // to check if the information needed is complete before click some button
                /*
                if (editName==null || editEmail==null || editPassword==null)
                {
                    Toast.makeText(RegisterActivity.this,"All information above is required !",Toast.LENGTH_LONG).show();
                }
                 */

                //if (false==true){

                //}

                //else
                //{
                    registerUser();
                //}
                break;
        }
    }


    private void registerUser()
    {
        String userName = editName.getText().toString().trim();
        String userEmail = editEmail.getText().toString().trim();
        String userPassword = editPassword.getText().toString().trim();

        btnRegisterCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                finish();
            }

        });

        if(userName.isEmpty())
        {
            editName.setError("Username is required !");
            editName.requestFocus();
            return;
        }
        if(userEmail.isEmpty())
        {
            editEmail.setError("Email is required !");
            editEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
        {
            editEmail.setError("Please provide valid Email !");
            editEmail.requestFocus();
            return;
        }
        if(userPassword.isEmpty())
        {
            editPassword.setError("Password is required !");
            editPassword.requestFocus();
            return;
        }
        if (userPassword.length()<6)
        {
            editPassword.setError("Min password length should be 6 characters !");
            editPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        btnRegisterConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", userName);
                hashMap.put("Email", userEmail);

                databaseReference.child("Users")
                        .child(userName)
                        .setValue(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(RegisterActivity.this, "Data Upload Successfully !", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(RegisterActivity.this, "Failed to Upload Data, Try Again !", Toast.LENGTH_SHORT).show();
                            }
                        });
            }



        });
        progressBar.setVisibility(View.GONE);


        /*
        myAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(task ->
                {
                    if (task.isSuccessful())
                    {
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(task1 ->
                                {
                                    if (task1.isSuccessful())
                                    {
                                        Toast.makeText(RegisterActivity.this,"Registered successfully!",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    }
                                    else
                                    {
                                        Toast.makeText(RegisterActivity.this,"Failed to register ! Try again !",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                });
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this,"Failed to register! Email was Exists!",Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });

         */
    }
}
