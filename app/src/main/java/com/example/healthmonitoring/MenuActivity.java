package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private static final String TAG = "MenuApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        outInfoPatient();
        goPressure();
        goHeftSteps();
    }

    public void  outInfoPatient() {
        Patient patient = getIntent().getParcelableExtra("patient");
        TextView patientInfo = findViewById(R.id.patientInfo);

        if(patient.getSurname().equals("")
        && patient.getName().equals("")
        && patient.getFeature().equals("")) {

            patientInfo.setText(String.format(getString(R.string.patientInfoNodName),
                    getString(R.string.unknown),
                    patient.getAge()));
        } else {
            patientInfo.setText(String.format(getString(R.string.patientInfo),
                    patient.getSurname(),
                    patient.getName(),
                    patient.getFeature(),
                    patient.getAge()));
        }
    }

    public void goPressure() {
        Button goPressure = findViewById(R.id.buttonPressure);
        goPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, getString(R.string.move_save_pressure));
                Intent intentPressure = new Intent(MenuActivity.this,
                        PressureActivity.class);
                startActivity(intentPressure);
            }
        });
    }

    public void goHeftSteps() {
        Button goHeftSteps = findViewById(R.id.buttonHeftSteps);
        goHeftSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, getString(R.string.move_save_heft));
                Intent intentHeftSteps = new Intent(MenuActivity.this,
                        HeftStepsActivity.class);
                startActivity(intentHeftSteps);
            }
        });
    }
}
