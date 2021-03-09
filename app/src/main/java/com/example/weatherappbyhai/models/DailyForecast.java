package com.example.weatherappbyhai.models;

import java.util.Date;
import java.util.List;

public class DailyForecast {
    public Date Date;
    public int EpochDate;
    public DailyTemperature Temperature;
    public TimeOfDay Day;
    public TimeOfDay Night;
    public List<String> Sources;
    public String MobileLink;
    public String Link;
}
