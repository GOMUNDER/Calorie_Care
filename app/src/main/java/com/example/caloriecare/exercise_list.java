package com.example.caloriecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class exercise_list extends AppCompatActivity {
    String exer_list[]={"Chest","Back","Shoulder","Arm","Leg"};
    int exer_icon[]={R.drawable.chest,R.drawable.back,R.drawable.shoulders,R.drawable.muscle,R.drawable.knee};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportlist);

        listView=(ListView)findViewById(R.id.listview);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(),exer_list,exer_icon);
        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    startActivity(new Intent(exercise_list.this,ChestActivity.class));
                }
                else if (i==1){
                    startActivity(new Intent(exercise_list.this,BackActivity.class));
                }
                else if (i==2){
                    startActivity(new Intent(exercise_list.this,ShoulderActivity.class));
                }
                else if (i==3){
                    startActivity(new Intent(exercise_list.this,Arm_Activity.class));
                }
                else if (i==4){
                    startActivity(new Intent(exercise_list.this,LegActivity.class));
                }
            }
        });
    }
}