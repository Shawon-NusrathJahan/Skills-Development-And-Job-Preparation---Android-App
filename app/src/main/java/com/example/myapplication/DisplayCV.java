package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DisplayCV extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private TextView tvFullName, tvAddress, tvContact, tvEducation, tvSkills, tvExperienceTitle, tvExperienceDescription, tvLanguages;
    private Button btnDownload;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cv);

        // Initialize TextViews
        tvFullName = findViewById(R.id.tv_full_name);
        tvAddress = findViewById(R.id.tv_address);
        tvContact = findViewById(R.id.tv_contact);
        tvEducation = findViewById(R.id.tv_education);
        tvSkills = findViewById(R.id.tv_skills);
        tvExperienceTitle = findViewById(R.id.tv_experience_title);
        tvExperienceDescription = findViewById(R.id.tv_experience_description);
        tvLanguages = findViewById(R.id.tv_languages);

        // Initialize Buttons
        btnDownload = findViewById(R.id.btn_download);
        btnShare = findViewById(R.id.btn_share);

        // Get the CV data from the Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            setCVData(extras);
        }

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(DisplayCV.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(DisplayCV.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
                } else {
                    generatePDF();
                }
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareCVInfo();
            }
        });
    }

    private void setCVData(Bundle extras) {
        // Set the CV data to respective TextViews
        tvFullName.setText(extras.getString("name"));
        tvAddress.setText(extras.getString("address"));
        tvContact.setText(extras.getString("contact"));
        tvEducation.setText(extras.getString("education"));
        tvSkills.setText(extras.getString("skills"));
        tvExperienceTitle.setText(extras.getString("experienceTitle"));
        tvExperienceDescription.setText(extras.getString("experienceDescription"));
        tvLanguages.setText(extras.getString("languages"));
    }

    private void generatePDF() {
        // Define the file path and name
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CV.pdf";
        PdfDocument pdfDocument = new PdfDocument();

        try {
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
            PdfDocument.Page page = pdfDocument.startPage(pageInfo);
            Canvas canvas = page.getCanvas();

            // Draw content on the PDF
            Paint paint = new Paint();
            paint.setTextSize(12);

            // Use a formatted string for better organization
            String cvContent = getCVContent();
            canvas.drawText(cvContent, 10, 25, paint); // Adjust position as needed

            pdfDocument.finishPage(page);

            // Write the document content
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            pdfDocument.writeTo(fos);
            pdfDocument.close();
            fos.close();

            Toast.makeText(this, "PDF saved to: " + filePath, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error creating PDF", Toast.LENGTH_SHORT).show();
        }
    }

    private String getCVContent() {
        return "Name: " + tvFullName.getText().toString() + "\n" +
                "Address: " + tvAddress.getText().toString() + "\n" +
                "Contact: " + tvContact.getText().toString() + "\n" +
                "Education: " + tvEducation.getText().toString() + "\n" +
                "Skills: " + tvSkills.getText().toString() + "\n" +
                "Experience Title: " + tvExperienceTitle.getText().toString() + "\n" +
                "Experience Description: " + tvExperienceDescription.getText().toString() + "\n" +
                "Languages: " + tvLanguages.getText().toString();
    }

    private void shareCVInfo() {
        // Get the CV text
        String cvContent = getCVContent();
        String subject = "My CV Information";

        // Create the intent to send email
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, cvContent);
        startActivity(Intent.createChooser(emailIntent, "CV generated by NEXTSTEP.inc"));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                generatePDF();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
