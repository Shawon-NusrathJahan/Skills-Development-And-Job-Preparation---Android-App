package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        CardView jobPreparation, makeCV, careerGuidelines, skillsDevelopment, languageLearning;

        jobPreparation    = findViewById(R.id.card_job_prep);
        makeCV            = findViewById(R.id.card_cv);
        careerGuidelines  = findViewById(R.id.card_career_guide);
        skillsDevelopment = findViewById(R.id.card_skills_develop);
        languageLearning  = findViewById(R.id.card_lang_learn);

        jobPreparation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JobPreparation.class);
                startActivity(intent);
            }
        });
        makeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MakeCV.class);
                startActivity(intent);
            }
        });
        careerGuidelines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CareerGuidelines.class);
                startActivity(intent);
            }
        });
        skillsDevelopment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SkillsDevelopment.class);
                startActivity(intent);
            }
        });
        languageLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LanguageLearning.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Log.i("state", "App is created!");
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.i("state", "onResume() Method is Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("state", "onPause() Method is Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("state", "onStop() Method is Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("state", "onRestart() Method is Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("state", "onDestroy() Method is Called");
    }
}