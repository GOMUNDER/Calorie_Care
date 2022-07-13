package com.example.caloriecare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caloriecare.R;
import com.example.caloriecare.UserActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoAccountActivity extends AppCompatActivity implements View.OnClickListener
{
    private ImageView information_iv;
    private Button btn_info_Edit;
    private TextView name,email,identity,phone,address;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_account);
/*
        name = (TextView) findViewById(R.id.name_info);
        email = (TextView) findViewById(R.id.email_info);
        identity = (TextView) findViewById(R.id.identity_info);
        phone = (TextView) findViewById(R.id.phone_info);
        address = (TextView) findViewById(R.id.address_info);
        information_iv = (ImageView) findViewById(R.id.infomation_iv);
        btn_info_Edit = (Button) findViewById(R.id.btn_info_edit);

 */

        information_iv.setOnClickListener(this);
        btn_info_Edit.setOnClickListener(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                UserActivity userProfile = snapshot.getValue(UserActivity.class);

                if (userProfile != null)
                {
                    name.setText(userProfile.fullName);
                    email.setText(userProfile.email);
                    identity.setText(userProfile.identity);
                    phone.setText(userProfile.phoneNumber);
                    address.setText(userProfile.address);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Toast.makeText(getApplicationContext(),"Something wrong !",Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onClick(View view)
    {
        /*
        switch (view.getId())
        {
            case R.id.infomation_iv:
                finish();
                break;
            case R.id.btn_info_edit:
                startActivity(new Intent(this, info_btn_edit.class));
                break;
        }

         */


    }
}