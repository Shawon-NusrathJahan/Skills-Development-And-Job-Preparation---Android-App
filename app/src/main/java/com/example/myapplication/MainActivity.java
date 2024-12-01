package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ShapeableImageView btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        btnProfile = findViewById(R.id.btn_profile);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    // User is logged in, navigate to the WebViewActivity
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            }
        });

        GridView gridView = findViewById(R.id.card_grid_view);

        // Prepare data
        List<CardItem> cardItems = new ArrayList<>();
        cardItems.add(new CardItem(R.drawable.card_bg_job_preparation, R.drawable.ic_job_preparation, "Job Preparation"));
        cardItems.add(new CardItem(R.drawable.card_bg_make_cv, R.drawable.ic_make_cv, "Make CV"));
        cardItems.add(new CardItem(R.drawable.card_bg_career_guidelines, R.drawable.ic_career_guidelines, "Career Guidelines"));
        cardItems.add(new CardItem(R.drawable.card_bg_skill_development, R.drawable.ic_skills_development, "Skills Development"));
        cardItems.add(new CardItem(R.drawable.card_bg_lang_learning, R.drawable.ic_language_learning, "Language Learning"));

        // Set adapter
        CardAdapter adapter = new CardAdapter(this, cardItems);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            CardItem selectedItem = (CardItem) parent.getItemAtPosition(position);
            Snackbar.make(view, "Clicked: " + selectedItem.getTitle(), Snackbar.LENGTH_SHORT).show();

            // Handle item click (e.g., navigate to a new activity)
            Class<?> targetActivity;
            switch (position) {
                case 0:
                    targetActivity = JobPreparation.class;
                    break;
                case 1:
                    targetActivity = MakeCV.class;
                    break;
                case 2:
                    targetActivity = CareerGuidelines.class;
                    break;
                case 3:
                    targetActivity = SkillsDevelopment.class;
                    break;
                case 4:
                    targetActivity = LanguageLearning.class;
                    break;
                default:
                    return; // No action for invalid position
            }

            // Start the corresponding activity
            Intent intent = new Intent(getApplicationContext(), targetActivity);
            startActivity(intent);
        });


//        CardView jobPreparation, makeCV, careerGuidelines, skillsDevelopment, languageLearning;
//
//        jobPreparation    = findViewById(R.id.card_job_prep);
//        makeCV            = findViewById(R.id.card_cv);
//        careerGuidelines  = findViewById(R.id.card_career_guide);
//        skillsDevelopment = findViewById(R.id.card_skills_develop);
//        languageLearning  = findViewById(R.id.card_lang_learn);
//
//        jobPreparation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), JobPreparation.class);
//                startActivity(intent);
//            }
//        });
//        makeCV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MakeCV.class);
//                startActivity(intent);
//            }
//        });
//        careerGuidelines.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), CareerGuidelines.class);
//                startActivity(intent);
//            }
//        });
//        skillsDevelopment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SkillsDevelopment.class);
//                startActivity(intent);
//            }
//        });
//        languageLearning.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), LanguageLearning.class);
//                startActivity(intent);
//            }
//        });


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