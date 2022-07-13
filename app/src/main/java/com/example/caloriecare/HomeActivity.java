

package com.example.caloriecare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
}
/*

    private Button loginButton, registerButton;
    private Button toLoginButton, toRegisterButton, toStepCounterButton;
    private Button cancelLoginButton, cancelRegButton;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText getUsername, getPassword, getEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loginButton = (Button) findViewById(R.id.btn_home_login);
        registerButton = (Button) findViewById(R.id.btn_home_register);
        toStepCounterButton = (Button) findViewById(R.id.btn_to_step_counter);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                //createdialog_log();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(intent);
                //createdialog_reg();
            }
        });

        toStepCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, StepCountActivity.class);
                startActivity(intent);
            }
        });


    }

    //--
    public void createdialog_log(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View log_popup = getLayoutInflater().inflate(R.layout.activity_login,null);
        // ga jalan? overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        getUsername = (EditText) log_popup.findViewById(R.id.edit_reg_name);
        getPassword = (EditText) log_popup.findViewById(R.id.edit_reg_password);

        toLoginButton = (Button) log_popup.findViewById(R.id.btn_login_login);
        cancelLoginButton = (Button) log_popup.findViewById(R.id.btn_reg_cancel);

        dialogBuilder.setView(log_popup);
        dialog = dialogBuilder.create();
        dialog.show();

        toLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //login
                Toast.makeText(getApplicationContext(),"Ntar LOGIN",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, MainActivity3.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        cancelLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Balik
                dialog.dismiss();
            }
        });

    }

    public void createdialog_reg(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View sig_popup = getLayoutInflater().inflate(R.layout.activity_register,null);

        getUsername = (EditText) sig_popup.findViewById(R.id.edit_reg_name);
        getPassword = (EditText) sig_popup.findViewById(R.id.edit_reg_password);
        getEmail = (EditText) sig_popup.findViewById(R.id.edit_reg_email);

        toRegisterButton = (Button) sig_popup.findViewById(R.id.btn_register_register);
        cancelRegButton = (Button) sig_popup.findViewById(R.id.btn_reg_cancel);

        dialogBuilder.setView(sig_popup);
        dialog = dialogBuilder.create();
        dialog.show();

        toRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sign up
                Toast.makeText(getApplicationContext(),"Ntar Sign Up",Toast.LENGTH_SHORT).show();
            }
        });

        cancelRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Balik
                dialog.dismiss();
            }
        });

    }
    //--




}

*/

