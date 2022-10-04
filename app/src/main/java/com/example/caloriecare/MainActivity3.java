package com.example.caloriecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.internal.TextWatcherAdapter;

public class MainActivity3 extends AppCompatActivity {

    EditText w,h;
    TextView bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        w = findViewById(R.id.editweight);
        h = findViewById(R.id.editheight);
        bmi = findViewById(R.id.hasilBMI);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!w.getText().toString().equals("") && !h.getText().toString().equals("")){
                    int tempw = (int) Float.parseFloat(String.valueOf(w.getText()));
                    int temph = (int) Float.parseFloat(String.valueOf(h.getText()));
                    bmi.setText(String.valueOf((tempw/temph/temph)*10000));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        w.addTextChangedListener(textWatcher);
        h.addTextChangedListener(textWatcher);

        Button startbtn = (Button) findViewById(R.id.startbtn);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, Homepage_mainmenu.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

    }
}