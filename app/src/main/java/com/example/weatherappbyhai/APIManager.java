package com.example.weatherappbyhai;

import com.example.weatherappbyhai.models.Daily;
import com.example.weatherappbyhai.models.Hourly;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String SERVER = "http://dataservice.accuweather.com/";
    String API_KEY = "93Qg780lHwYM4SO58n7DFPLqHg4oKADn";
    String QUERY = "?apikey=" + API_KEY + "&language=vi-vn&metric=true";

    @GET("forecasts/v1/daily/5day/353412" + QUERY)
    Call<Daily> getDailyForeCast();

    @GET("forecasts/v1/hourly/12hour/353412" + QUERY)
    Call<List<Hourly>> getHourlyForecast();
}
