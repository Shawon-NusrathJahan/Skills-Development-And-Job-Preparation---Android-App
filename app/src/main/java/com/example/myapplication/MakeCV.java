package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MakeCV extends DashboardActivity {

    private EditText etName, etAddress, etContact, etEducation, etSkills, etExperienceTitle, etExperienceDescription, etLanguages;
    private Button btnGenerate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_cv);

        // Initialize fields
        etName = findViewById(R.id.et_name);
        etAddress = findViewById(R.id.et_address);
        etContact = findViewById(R.id.et_contact);
        etEducation = findViewById(R.id.et_education);
        etSkills = findViewById(R.id.et_skills);
        etExperienceTitle = findViewById(R.id.et_experience_title);
        etExperienceDescription = findViewById(R.id.et_experience_description);
        etLanguages = findViewById(R.id.et_languages);
        btnGenerate = findViewById(R.id.btn_generate);

        // Set click listener on Generate button
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateCV();
            }
        });
    }

    private void generateCV() {
        // Retrieve input data
        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        String contact = etContact.getText().toString();
        String education = etEducation.getText().toString();
        String skills = etSkills.getText().toString();
        String experienceTitle = etExperienceTitle.getText().toString();
        String experienceDescription = etExperienceDescription.getText().toString();
        String languages = etLanguages.getText().toString();

        // Create bundle for data passing
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("address", address);
        bundle.putString("contact", contact);
        bundle.putString("education", education);
        bundle.putString("skills", skills);
        bundle.putString("experienceTitle", experienceTitle);
        bundle.putString("experienceDescription", experienceDescription);
        bundle.putString("languages", languages);

        // Start CV Display Activity
        Intent intent = new Intent(MakeCV.this, DisplayCV.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(getApplicationContext(), "“Begin somewhere. You cannot build a reputation on what you intend to do.” ― Liz Smith", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
