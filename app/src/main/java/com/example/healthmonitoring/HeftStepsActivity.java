package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class HeftStepsActivity extends AppCompatActivity {
    private static final String TAG = "HeftStepsApp";
    private EditText weight;
    private EditText steps;
    Map<String, HeftStep> heftStepMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heft_steps);
        saveValue();
    }

    public void saveValue() {
        Button button = findViewById(R.id.button_save_heft);
        weight = findViewById(R.id.editWeight);
        steps = findViewById(R.id.editSteps);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Date currentDate = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy",
                        Locale.getDefault());
                String dateText = dateFormat.format(currentDate);
                try {
                    int weightSave = Integer.parseInt(weight.getText().toString());
                    int stepsSave = Integer.parseInt(steps.getText().toString());
                    HeftStep heftStep = new HeftStep(weightSave, stepsSave);
                    heftStepMap.put(dateText, heftStep);
                    getMap(dateText);
                    weight.setText("");
                    steps.setText("");
                } catch (Exception exc) {
                    Log.e(TAG, "Получено исключение", exc);
                    Toast e = Toast.makeText(HeftStepsActivity.this,
                            "Не корректно заполнена форма", Toast.LENGTH_LONG);
                    e.show();
                }
            }
        });
    }

    public void getMap(String dateText) {
        TextView viewHeft = findViewById(R.id.viewHeft);
            viewHeft.setText(String.format(getString(R.string.viewHeft),
                    dateText,
                    heftStepMap.get(dateText).getWeight(),
                    heftStepMap.get(dateText).getSteps()));
    }
}
