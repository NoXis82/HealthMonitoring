package com.example.healthmonitoring;

public class Pressure {
    private int upPressure;
    private int lowPressure;
    private int pulse;
    boolean tachycardia;

    public Pressure(int upPressure, int lowPressure, int pulse, boolean tachycardia) {
        this.upPressure = upPressure;
        this.lowPressure = lowPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
    }


    public int getUpPressure() {
        return upPressure;
    }

    public int getLowPressure() {
        return lowPressure;
    }

    public int getPulse() {
        return pulse;
    }

    public boolean isTachycardia() {
        return tachycardia;
    }
}
