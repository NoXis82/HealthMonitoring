package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainApp";
    private Button mainSaveButton;
    private EditText surname;
    private EditText name;
    private EditText feature;
    private EditText age;
    private Patient patient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainSave();
    }

    public void mainSave() {
        mainSaveButton = findViewById(R.id.button_main_save);
        surname = findViewById(R.id.editSurname);
        name = findViewById(R.id.editName);
        feature = findViewById(R.id.editFeature);
        age = findViewById(R.id.editAge);
        mainSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int agePatient = Integer.parseInt(age.getText().toString());
                    patient = new Patient(surname.getText().toString(),
                            name.getText().toString(),
                            feature.getText().toString(),
                            agePatient
                    );
                    Log.i(TAG, getString(R.string.new_obj));
                    Intent intentMenu = new Intent(MainActivity.this,
                            MenuActivity.class);
                    intentMenu.putExtra("patient", patient);
                    startActivity(intentMenu);
                    finish();
                } catch (Exception exc) {
                    Log.e(TAG, getString(R.string.exception), exc);
                    Toast.makeText(MainActivity.this,
                            R.string.error_form, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
