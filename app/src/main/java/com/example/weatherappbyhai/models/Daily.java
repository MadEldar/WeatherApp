package com.example.weatherappbyhai.models;

import java.util.List;

public class Daily {
    private Headline HeadLine;
    private List<DailyForecast> DailyForecasts;

    public Daily(Headline headLine, List<DailyForecast> dailyForecasts) {
        HeadLine = headLine;
        DailyForecasts = dailyForecasts;
    }

    public Headline getHeadLine() {
        return HeadLine;
    }

    public void setHeadLine(Headline headLine) {
        HeadLine = headLine;
    }

    public List<DailyForecast> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }
}
