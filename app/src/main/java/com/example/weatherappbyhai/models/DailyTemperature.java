package com.example.weatherappbyhai.models;

public class DailyTemperature {
    private Temperature Minimum;
    private Temperature Maximum;

    public DailyTemperature(Temperature minimum, Temperature maximum) {
        Minimum = minimum;
        Maximum = maximum;
    }

    public Temperature getMinimum() {
        return Minimum;
    }

    public void setMinimum(Temperature minimum) {
        Minimum = minimum;
    }

    public Temperature getMaximum() {
        return Maximum;
    }

    public void setMaximum(Temperature maximum) {
        Maximum = maximum;
    }
}
