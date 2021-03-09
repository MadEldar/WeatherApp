package com.example.weatherappbyhai.models;

import java.util.Date;
import java.util.List;

public class DailyForecast {
    private Date Date;
    private int EpochDate;
    private DailyTemperature Temperature;
    private TimeOfDay Day;
    private TimeOfDay Night;
    private List<String> Sources;
    private String MobileLink;
    private String Link;

    public DailyForecast(java.util.Date date, int epochDate, DailyTemperature temperature, TimeOfDay day, TimeOfDay night, List<String> sources, String mobileLink, String link) {
        Date = date;
        EpochDate = epochDate;
        Temperature = temperature;
        Day = day;
        Night = night;
        Sources = sources;
        MobileLink = mobileLink;
        Link = link;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getEpochDate() {
        return EpochDate;
    }

    public void setEpochDate(int epochDate) {
        EpochDate = epochDate;
    }

    public DailyTemperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(DailyTemperature temperature) {
        Temperature = temperature;
    }

    public TimeOfDay getDay() {
        return Day;
    }

    public void setDay(TimeOfDay day) {
        Day = day;
    }

    public TimeOfDay getNight() {
        return Night;
    }

    public void setNight(TimeOfDay night) {
        Night = night;
    }

    public List<String> getSources() {
        return Sources;
    }

    public void setSources(List<String> sources) {
        Sources = sources;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public void setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
