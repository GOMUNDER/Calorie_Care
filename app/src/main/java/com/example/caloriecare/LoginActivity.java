/*package com.example.caloriecare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity
        implements OnCompleteListener<AuthResult>
{
    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference reference;

    private String userID;
    private ProgressBar progressBar;
    private TextView forgotPassword;
    private EditText editEmail,editPassword;
    private Button signIn, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.edit_login_email);
        editPassword = findViewById(R.id.edit_login_password);
        firebaseAuth = FirebaseAuth.getInstance();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void onLogin (View view) {
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, this);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show();
            MainActivity.VALID_USER = true;


        }
        else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }


    //--
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forgotPassword = (TextView) findViewById(R.id.text_click_forget_password);
        editEmail = (EditText) findViewById(R.id.edit_reg_email);
        editPassword = (EditText) findViewById(R.id.edit_reg_password);
        signIn = (Button) findViewById(R.id.btn_register_register);
        cancel = (Button) findViewById(R.id.btn_reg_cancel);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        myAuth = FirebaseAuth.getInstance();

        cancel.setOnClickListener(this);
        signIn.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_register_register:
                userLogin();
                break;
            case R.id.text_click_forget_password:
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                break;
            case R.id.btn_reg_cancel:
                finish();
        }
    }
    private void userLogin()
    {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        if(email.isEmpty())
        {
            editEmail.setError("Email is required !");
            editEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editEmail.setError("Please provide valid Email !");
            editEmail.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            editPassword.setError("Password is required !");
            editPassword.requestFocus();
            return;
        }
        if (password.length()<6)
        {
            editPassword.setError("Min password length should be 6 characters !");
            editPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        myAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {//redirect to StepCountActivity
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    reference = FirebaseDatabase.getInstance().getReference("Users");
                    userID = user.getUid();

                    reference.child(userID).child("identity").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task)
                        {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Intent intent = new Intent(LoginActivity.this, StepCountActivity.class);
                                startActivity(intent);


//                                Toast.makeText(LoginActivity.this,String.valueOf(task.getResult().getValue()),Toast.LENGTH_LONG).show();
//                                progressBar.setVisibility(View.GONE);
//                                if (String.valueOf(task.getResult().getValue()).matches("Seller"))
//                                {
//                                    jumpActivity(1);
//                                }
//                                else if (String.valueOf(task.getResult().getValue()).matches("Buyer"))
//                                {
//                                    jumpActivity(2);
//                                }

                            }
                        }
                    });
                    Toast.makeText(LoginActivity.this,"Successful Login !",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(LoginActivity.this, StepCountActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Failed to Login ! Please check your credentials",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
    //--//

    //--
    private void jumpActivity(int i)
    {
        switch (i)
        {
            case 2:
                startActivity(new Intent(this, First_activity.class));
                break;
            case 1:
                startActivity(new Intent(this, SellerStartActivity.class));
                break;
        }
    }
    //--//
}

 */

package com.example.caloriecare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/*
import com.example.caloriecare.CourierActivity;
import com.example.caloriecare.Restaurant;
import com.example.caloriecare.restaurant.RestaurantInfoActivity;
import com.example.caloriecare.sellerActivity.SellerStartActivity;

 */
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView register;
    private EditText editEmail,editPassword;
    private Button signIn;
    private FirebaseUser user;
    private FirebaseAuth myAuth;
    private DatabaseReference reference;
    private String userID;
    private ProgressBar progressBar;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forgotPassword = (TextView) findViewById(R.id.toforgotPassword);
        register = (TextView) findViewById(R.id.toregister);
        editEmail = (EditText) findViewById(R.id.edit_login_email);
        editPassword = (EditText) findViewById(R.id.edit_login_password);
        signIn = (Button) findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        myAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(this);
        signIn.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.toregister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btn_login:
                userLogin();
                break;
            case R.id.toforgotPassword:
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                break;
        }
    }
    private void userLogin()
    {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        if(email.isEmpty())
        {
            editEmail.setError("Email is required !");
            editEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editEmail.setError("Please provide valid Email !");
            editEmail.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            editPassword.setError("Password is required !");
            editPassword.requestFocus();
            return;
        }
        if (password.length()<6)
        {
            editPassword.setError("Min password length should be 6 characters !");
            editPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        myAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {//redirect to First_activity
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    reference = FirebaseDatabase.getInstance().getReference("Users");
                    userID = user.getUid();

                    reference.child(userID).child("identity").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task)
                        {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this,String.valueOf(task.getResult().getValue()),Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);

                                if (String.valueOf(task.getResult().getValue()).matches("Seller"))//seller
                                {
                                    reference.child(userID).child("restaurantName").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>()
                                    {//get() restaurant name
                                        @Override
                                        public void onComplete(@NonNull Task<DataSnapshot> task)
                                        {
                                            if (!task.isSuccessful())
                                            {
                                                Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_LONG).show();
                                            }
                                            else
                                            {
                                                Toast.makeText(LoginActivity.this,"res name :"+String.valueOf(task.getResult().getValue()),Toast.LENGTH_LONG).show();

                                                if (String.valueOf(task.getResult().getValue()).matches(""))
                                                {
                                                    jumpActivity(1);
                                                }
                                                else if (!String.valueOf(task.getResult().getValue()).matches(""))
                                                {
                                                    jumpActivity(4);
                                                }
                                            }
                                        }
                                    });
                                }
                                else if (String.valueOf(task.getResult().getValue()).matches("Buyer"))//buyer
                                {
                                    jumpActivity(2);
                                }
                                else if (String.valueOf(task.getResult().getValue()).matches("Courier"))//courier
                                {
                                    jumpActivity(3);
                                }
                            }
                        }
                    });
                    Toast.makeText(LoginActivity.this,"Successful Login !",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(LoginActivity.this, FirstActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Failed to Login ! Please check your credentials",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    private void jumpActivity(int i)
    {
        /*
        switch (i)
        {
            case 1:
                startActivity(new Intent(this, RestaurantInfoActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, First_activity.class));
                break;
            case 3:
                startActivity(new Intent(this, CourierActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, SellerStartActivity.class));
                break;

        }

         */
    }
}