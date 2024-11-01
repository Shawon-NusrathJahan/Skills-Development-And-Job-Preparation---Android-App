package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class BaseActivity extends AppCompatActivity {
    TextView tvActivityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_base);


        setupBottomNavigation();
        tvActivityName = findViewById(R.id.tv_activity_name);
        setActivityDetails(getIntent().getStringExtra("activity_name"));
    }

    protected void setupBottomNavigation() {

        ImageButton jobPreparation = findViewById(R.id.btn_job_preparation);
        ImageButton makeCV = findViewById(R.id.btn_make_cv);
        ImageButton careerGuidelines = findViewById(R.id.btn_career_guidelines);
        ImageButton skillsDevelopment = findViewById(R.id.btn_skill_development);
        ImageButton languageLearning = findViewById(R.id.btn_language_learning);

        jobPreparation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JobPreparation.class);
                intent.putExtra("activity_name", getString(R.string.job_preparation));
                startActivity(intent);
            }
        });
        makeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MakeCV.class);
                intent.putExtra("activity_name", getString(R.string.make_cv));
                startActivity(intent);
            }
        });
        careerGuidelines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CareerGuidelines.class);
                intent.putExtra("activity_name", getString(R.string.career_guidelines));
                startActivity(intent);
            }
        });
        skillsDevelopment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SkillsDevelopment.class);
                intent.putExtra("activity_name", getString(R.string.skills_development));
                startActivity(intent);
            }
        });
        languageLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LanguageLearning.class);
                intent.putExtra("activity_name", getString(R.string.language_learning));
                startActivity(intent);
            }
        });

    }

    private void setActivityDetails(String activityName) {
        int current_activity_colour = R.color.asset_medium;
        if (activityName != null) {
            tvActivityName.setText(activityName);

            switch (activityName) {
                case "Job Preparation":
                    current_activity_colour = R.color.color_job_preparation;
                    ImageButton btnJobPreparation = findViewById(R.id.btn_job_preparation);
                    btnJobPreparation.setColorFilter(current_activity_colour);
                    break;
                case "Make CV":
                    current_activity_colour = R.color.color_make_cv;
                    ImageButton btnMakeCV = findViewById(R.id.btn_make_cv);
                    btnMakeCV.setColorFilter(current_activity_colour);
                    break;
                case "Career Guidelines":
                    current_activity_colour = R.color.color_career_guidelines;
                    ImageButton btnCareerGuidelines = findViewById(R.id.btn_career_guidelines);
                    btnCareerGuidelines.setColorFilter(current_activity_colour);
                    break;
                case "Skills Development":
                    current_activity_colour = R.color.color_skills_development;
                    ImageButton btnSkillDevelopment = findViewById(R.id.btn_skill_development);
                    btnSkillDevelopment.setColorFilter(current_activity_colour);
                    break;
                case "Language Learning":
                    current_activity_colour = R.color.color_language_learning;
                    ImageButton btnLanguageLearning = findViewById(R.id.btn_language_learning);
                    btnLanguageLearning.setColorFilter(current_activity_colour);
                    break;
            }

            // Set TextView color
            tvActivityName.setTextColor(ContextCompat.getColor(this, current_activity_colour));

        }
    }

}
