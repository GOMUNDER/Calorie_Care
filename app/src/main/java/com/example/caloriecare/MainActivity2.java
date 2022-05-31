package com.example.caloriecare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button btnlog;
    private Button btnsig;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText popup_username,popup_Password,popup_email;
    private Button log,sig,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnlog = (Button) findViewById(R.id.btnlog);
        btnsig = (Button) findViewById(R.id.btnsig);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createdialog_log();
            }
        });

        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createdialog_sig();
            }
        });
    }

    public void createdialog_log(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View log_popup = getLayoutInflater().inflate(R.layout.log_pop,null);
        // ga jalan? overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        popup_username = (EditText) log_popup.findViewById(R.id.popup_username);
        popup_Password = (EditText) log_popup.findViewById(R.id.popup_Password);

        log = (Button) log_popup.findViewById(R.id.log);
        cancel = (Button) log_popup.findViewById(R.id.cancel);

        dialogBuilder.setView(log_popup);
        dialog = dialogBuilder.create();
        dialog.show();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //login
                Toast.makeText(getApplicationContext(),"Ntar LOGIN",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Balik
                dialog.dismiss();
            }
        });

    }

    public void createdialog_sig(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View sig_popup = getLayoutInflater().inflate(R.layout.sig_pop,null);
        popup_username = (EditText) sig_popup.findViewById(R.id.popup_username);
        popup_Password = (EditText) sig_popup.findViewById(R.id.popup_Password);
        popup_email = (EditText) sig_popup.findViewById(R.id.popup_email);

        sig = (Button) sig_popup.findViewById(R.id.sig);
        cancel = (Button) sig_popup.findViewById(R.id.cancel);

        dialogBuilder.setView(sig_popup);
        dialog = dialogBuilder.create();
        dialog.show();

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sign up
                Toast.makeText(getApplicationContext(),"Ntar Sign Up",Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Balik
                dialog.dismiss();
            }
        });

    }

}