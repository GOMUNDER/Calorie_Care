package com.example.caloriecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Homepage_mainmenu extends AppCompatActivity {

    private ImageView breakfast,lunch,dinner,snack,diary,latihan,foto,diet;
    private TextView breakfast_text,lunch_text,dinner_text,snack_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_mainmenu);

        View overlay = findViewById(R.id.homepage_layout);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                        |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        breakfast = (ImageView) findViewById(R.id.breakfast);
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,add_makan.class));
            }
        });

        breakfast_text = (TextView) findViewById(R.id.breakfast_text);
        breakfast_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,add_makan.class));
            }
        });

        lunch = (ImageView) findViewById(R.id.lunch);
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,add_makan.class));
            }
        });

        lunch_text = (TextView) findViewById(R.id.lunch_text);
        lunch_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,add_makan.class));
            }
        });

        dinner = (ImageView) findViewById(R.id.dinner);
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,add_makan.class));
            }
        });

        dinner_text = (TextView) findViewById(R.id.dinner_text);
        dinner_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,add_makan.class));
            }
        });

        snack = (ImageView) findViewById(R.id.snack);
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,add_makan.class));
            }
        });

        snack_text = (TextView) findViewById(R.id.snack_text);
        snack_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,add_makan.class));
            }
        });

        diary = (ImageView) findViewById(R.id.diary);
        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,diary_page.class));
            }
        });

        latihan = (ImageView) findViewById(R.id.exercise);
        latihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,exercise_list.class));
            }
        });

        foto = (ImageView) findViewById(R.id.camera);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,addmeal_foto.class));
            }
        });

        diet = (ImageView) findViewById(R.id.diet);
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage_mainmenu.this,diet_page.class));
            }
        });

    }
}