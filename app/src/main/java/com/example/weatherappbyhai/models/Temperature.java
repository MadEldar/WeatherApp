package com.example.weatherappbyhai.models;

public class Temperature {
    public double Value;
    public String Unit;
    public int UnitType;

    public Temperature(double value, String unit, int unitType) {
        Value = value;
        Unit = unit;
        UnitType = unitType;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public int getUnitType() {
        return UnitType;
    }

    public void setUnitType(int unitType) {
        UnitType = unitType;
    }
}
