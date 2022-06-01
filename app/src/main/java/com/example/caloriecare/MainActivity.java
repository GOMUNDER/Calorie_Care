package com.example.caloriecare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    private ProgressBar progressBar;
    //private FirebaseAuth myAuth;

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        //myAuth = FirebaseAuth.getInstance();
    }


    @Override
    protected void onStart() {
        progressBar.setVisibility(View.VISIBLE);

        super.onStart();

        if (user == null) {
            progressBar.setVisibility(View.GONE);
        }
        if (user != null) {
            userID = user.getUid();
        }

        startActivity(new Intent(this, HomeActivity.class));


//        new Handler().postDelayed(new Runnable(){
//            public void run(){
//                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(intent);
//                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//                finish();
//            }
//        }, 3000); //2000 is time delayed in millseconds


    }
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        }, 3000); //2000 is time delayed in millseconds
    }




}