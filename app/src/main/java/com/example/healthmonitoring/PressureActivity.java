package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PressureActivity extends AppCompatActivity {
    private static final String TAG = "PressureApp";
    private EditText upPressure;
    private  EditText lowPressure;
    private EditText pulse;
    private Switch tachycardia;
    private boolean tachycardiaSave;
    Map<String, Pressure> pressureMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        savePressure();

    }

    public void savePressure() {
        Button savePressure = findViewById(R.id.button_pressure_save);
        upPressure = findViewById(R.id.editUpPressure);
        lowPressure = findViewById(R.id.editLowPressure);
        pulse = findViewById(R.id.editPulse);
        tachycardia = findViewById(R.id.switch_tachycardia);
        savePressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date currentDate = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss",
                        Locale.getDefault());
                String dateText = dateFormat.format(currentDate);
                try {
                    int upPressureSave = Integer.parseInt(upPressure.getText().toString());
                    int lowPressureSave = Integer.parseInt(lowPressure.getText().toString());
                    int pulseSave = Integer.parseInt(pulse.getText().toString());
                    tachycardia.setOnCheckedChangeListener(
                            new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView,
                                                             boolean isChecked) {
                                    tachycardiaSave = isChecked;
                                }
                            });
                    Pressure pressureSave = new Pressure(upPressureSave,
                            lowPressureSave,
                            pulseSave,
                            tachycardiaSave
                    );
                    pressureMap.put(dateText, pressureSave);
                    getMap(dateText);
                    upPressure.setText("");
                    lowPressure.setText("");
                    pulse.setText("");
                    tachycardia.setChecked(false);
                } catch (Exception exc) {
                    Log.e(TAG, getString(R.string.exception), exc);
                    Toast.makeText(PressureActivity.this,
                            R.string.error_form, Toast.LENGTH_LONG).show();

                }

            }
        });
    }

    public void getMap(String dateText) {
        String tachycardia;
        TextView viewPressure = findViewById(R.id.viewPressure);
        if (pressureMap.get(dateText).isTachycardia()) {
            tachycardia = getString(R.string.yes);
        } else {
            tachycardia = getString(R.string.no);
        }
        viewPressure.setText(String.format(getString(R.string.viewPressure),
                dateText,
                pressureMap.get(dateText).getUpPressure(),
                pressureMap.get(dateText).getLowPressure(),
                pressureMap.get(dateText).getPulse(),
                tachycardia
        ));
    }
}
