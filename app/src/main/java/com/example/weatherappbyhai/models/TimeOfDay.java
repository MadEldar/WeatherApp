package com.example.weatherappbyhai.models;

import android.annotation.SuppressLint;

public class TimeOfDay {
    private int Icon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private String PrecipitationType;
    private String PrecipitationIntensity;

    public TimeOfDay(int icon, String iconPhrase, boolean hasPrecipitation, String precipitationType, String precipitationIntensity) {
        Icon = icon;
        IconPhrase = iconPhrase;
        HasPrecipitation = hasPrecipitation;
        PrecipitationType = precipitationType;
        PrecipitationIntensity = precipitationIntensity;
    }

    public int getIcon() {
        return Icon;
    }

    @SuppressLint("DefaultLocale")
    public String getIconLink() {
        return "https://developer.accuweather.com/sites/default/files/" + String.format("%02d", Icon) + "-s.png";
    }

    public void setIcon(int icon) {
        Icon = icon;
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

    public String getPrecipitationType() {
        return PrecipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        PrecipitationType = precipitationType;
    }

    public String getPrecipitationIntensity() {
        return PrecipitationIntensity;
    }

    public void setPrecipitationIntensity(String precipitationIntensity) {
        PrecipitationIntensity = precipitationIntensity;
    }
}
