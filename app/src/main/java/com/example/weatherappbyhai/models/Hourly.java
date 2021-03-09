package com.example.weatherappbyhai.models;

import android.annotation.SuppressLint;

import java.util.Date;

public class Hourly {
    private Date DateTime;
    private int EpochDatetime;
    private int WeatherIcon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private boolean IsDaylight;
    private Temperature Temperature;
    private int PrecipitationProbability;
    private String MobileLink;
    private String Link;

    public Hourly(Date dateTime, int epochDatetime, int weatherIcon, String iconPhrase, boolean hasPrecipitation, boolean isDaylight, com.example.weatherappbyhai.models.Temperature temperature, int precipitationProbability, String mobileLink, String link) {
        DateTime = dateTime;
        EpochDatetime = epochDatetime;
        WeatherIcon = weatherIcon;
        IconPhrase = iconPhrase;
        HasPrecipitation = hasPrecipitation;
        IsDaylight = isDaylight;
        Temperature = temperature;
        PrecipitationProbability = precipitationProbability;
        MobileLink = mobileLink;
        Link = link;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public int getEpochDatetime() {
        return EpochDatetime;
    }

    public void setEpochDatetime(int epochDatetime) {
        EpochDatetime = epochDatetime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    @SuppressLint("DefaultLocale")
    public String getWeatherIconLink() {
        return "https://developer.accuweather.com/sites/default/files/" + String.format("%02d", WeatherIcon) + "-s.png";
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    public boolean isDaylight() {
        return IsDaylight;
    }

    public void setDaylight(boolean daylight) {
        IsDaylight = daylight;
    }

    public com.example.weatherappbyhai.models.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.example.weatherappbyhai.models.Temperature temperature) {
        Temperature = temperature;
    }

    public int getPrecipitationProbability() {
        return PrecipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        PrecipitationProbability = precipitationProbability;
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
