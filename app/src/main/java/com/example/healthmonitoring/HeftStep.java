package com.example.healthmonitoring;

public class HeftStep {
    private int weight;
    private int steps;

    public HeftStep(int weight, int steps) {
        this.weight = weight;
        this.steps = steps;
    }

    public int getWeight() {
        return weight;
    }

    public int getSteps() {
        return steps;
    }
}
