/*
package com.example.caloriecare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

//import com.example.caloriecare.R;
//import com.example.caloriecare.user.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity
        implements OnCompleteListener
{
    private Button btnRegisterConfirm, btnRegisterCancel;
    private EditText editName, editEmail, editPassword;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    //private FirebaseAuth myAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName = findViewById(R.id.edit_reg_name);
        editEmail = findViewById(R.id.edit_login_email);
        editPassword = findViewById(R.id.edit_login_password);

        btnRegisterConfirm = (Button) findViewById(R.id.btn_register);
        //btnRegisterCancel = (Button) findViewById(R.id.btn_reg_cancel);

        firebaseAuth = FirebaseAuth.getInstance();

        onRegister();

        btnRegisterCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void onRegister () {
        String userEmail = editEmail.getText().toString();
        String userPassword = editPassword.getText().toString();

        btnRegisterConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                        .addOnCompleteListener(RegisterActivity.this, RegisterActivity.this);
            }
        });


    }

    @Override
    public void onComplete(@NonNull Task task) {
        if (task.isSuccessful()) {
            Toast.makeText(this, "Register Account Success", Toast.LENGTH_LONG).show();
            addUser();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Register Account Failed", Toast.LENGTH_LONG).show();
        }

    }


    private void addUser() {
        progressBar.setVisibility(View.VISIBLE);
        String userName = editName.getText().toString();
        String userEmail = editEmail.getText().toString();
        String userPassword = editPassword.getText().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference userRef = firebaseDatabase.getReference("Users");
        //DatabaseReference infoRef = userRef.child(personalInformation);
        Map<String, Object> user = new HashMap<>();
        user.put("name", userName);
        user.put("email", userEmail);
        user.put("password", userPassword);
        //infoRef.updateChildren(user);
        progressBar.setVisibility(View.GONE);
    }

        //--
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

//                if (editName==null || editEmail==null || editPassword==null)
//                {
//                    Toast.makeText(RegisterActivity.this,"All information above is required !",Toast.LENGTH_LONG).show();
//                }
//

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
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);

         //--//

        //--
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

         //--//
    //}
}
*/


package com.example.caloriecare;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.caloriecare.R;
import com.example.caloriecare.UserActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView2;
    private Button signIn, seller, buyer;
    private EditText editFullName, editEmail, editPassword, editWeight;
    private ProgressBar progressBar;
    Spinner spinnerRegister;
    String identity = "none";
    String phoneNumber = "none";
    String address = "none";

    private FirebaseAuth myAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myAuth = FirebaseAuth.getInstance();
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        signIn = (Button) findViewById(R.id.btn_register);
        //spinnerRegister = (Spinner) findViewById(R.id.spinner_register);
        editFullName = (EditText) findViewById(R.id.edit_reg_name);
        editEmail = (EditText) findViewById(R.id.edit_reg_email);
        editPassword = (EditText) findViewById(R.id.edit_reg_password);
        editWeight = (EditText) findViewById(R.id.edit_reg_weight);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        imageView2.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView2:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btn_register:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        //String[] identity_temp = getResources().getStringArray(R.array.identify);
        //int index = spinnerRegister.getSelectedItemPosition();
        //identity = identity_temp[index];

        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String fullname = editFullName.getText().toString().trim();
        String weight = editWeight.getText().toString().trim();
        if (fullname.isEmpty()) {
            editFullName.setError("Username is required !");
            editFullName.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            editEmail.setError("Email is required !");
            editEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Please provide valid Email !");
            editEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editPassword.setError("Password is required !");
            editPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editPassword.setError("Min password length should be 6 characters !");
            editPassword.requestFocus();
            return;
        }
        if (weight.isEmpty()) {
            editWeight.setError("Please provide your weight !");
            editWeight.requestFocus();
        }

        progressBar.setVisibility(View.VISIBLE);
        myAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task ->
        {
            if (task.isSuccessful()) {
                UserActivity user = new UserActivity(fullname, email, identity, phoneNumber, address, weight);

                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(task1 ->
                {
                    if (task1.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Registered successfully, your name is " + fullname + " !", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);

                        /*
                        if (identity.matches("Seller")) {
                            FirebaseDatabase.getInstance().getReference("Seller").child(fullname).child("UID").setValue(FirebaseAuth.getInstance().getUid());
                        }
                        if (identity.matches("Courier")) {
                            FirebaseDatabase.getInstance().getReference("Courier").child(fullname).child("UID").setValue(FirebaseAuth.getInstance().getUid());
                        }

                         */

                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "Failed to register ! Try again !", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
            else {
                Toast.makeText(RegisterActivity.this, "Failed to register! Email was Exists!", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}

