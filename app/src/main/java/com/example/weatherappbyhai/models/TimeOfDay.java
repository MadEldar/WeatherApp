package com.example.weatherappbyhai.models;

public class TimeOfDay {
    public int Icon;
    public String IconPhrase;
    public boolean HasPrecipitation;
    public String PrecipitationType;
    public String PrecipitationIntensity;

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
