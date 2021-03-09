package com.example.weatherappbyhai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherappbyhai.models.Daily;
import com.example.weatherappbyhai.models.DailyForecast;
import com.example.weatherappbyhai.models.Hourly;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Daily daily;
    List<Hourly> hourlyForecast = new ArrayList<>();
    HourlyAdapter hourlyAdapter;
    DailyAdapter dailyAdapter;

    TextView tvTemperature, tvUnit, tvIconPhrase, tvLocation;
    ImageView ivIcon;
    RecyclerView rvHourlyForecast, rvDailyForecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTemperature = findViewById(R.id.tvTemperature);
        tvUnit = findViewById(R.id.tvUnit);
        tvIconPhrase = findViewById(R.id.tvIconPhrase);
        tvLocation = findViewById(R.id.tvLocation);
        ivIcon = findViewById(R.id.ivIcon);

        getDailyForecast();

        getHourlyForecast(this);

        hourlyAdapter = new HourlyAdapter(this, hourlyForecast);

        RecyclerView.LayoutManager layoutHourly = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                lp.width = getWidth() / 5;
                return super.checkLayoutParams(lp);
            }
        };

        rvHourlyForecast = findViewById(R.id.rvHourlyForecast);
        rvHourlyForecast.setLayoutManager(layoutHourly);
        rvHourlyForecast.setAdapter(hourlyAdapter);

        dailyAdapter = new DailyAdapter(this, new ArrayList<>());

        RecyclerView.LayoutManager layoutDaily = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                lp.width = getWidth() / 3;
                return super.checkLayoutParams(lp);
            }
        };

        rvDailyForecast = findViewById(R.id.rvDailyForecast);
        rvDailyForecast.setLayoutManager(layoutDaily);
        rvDailyForecast.setAdapter(dailyAdapter);
    }

    private void getDailyForecast() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getDailyForeCast().enqueue(new Callback<Daily>() {
            @Override
            public void onResponse(Call<Daily> call, Response<Daily> response) {
                daily = response.body();
                dailyAdapter.reloadData(daily.getDailyForecasts());
            }

            @Override
            public void onFailure(Call<Daily> call, Throwable t) {
                Log.d("Debug", t.getMessage());
            }
        });
    }

    private void getHourlyForecast(Activity activity) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);
        service.getHourlyForecast().enqueue(new Callback<List<Hourly>>() {
            @Override
            public void onResponse(Call<List<Hourly>> call, Response<List<Hourly>> response) {
                if (response.isSuccessful()) {
                    hourlyForecast = response.body();
                    hourlyAdapter.reloadData(hourlyForecast);

                    Hourly currentForecast = hourlyForecast.iterator().next();

                    tvIconPhrase.setText(String.valueOf(currentForecast.getIconPhrase()));
                    tvTemperature.setText(String.valueOf(currentForecast.getTemperature().getValue()));
                    Resources res = getResources();
                    tvUnit.setText(String.format(res.getString(R.string.app_unit), currentForecast.getTemperature().getUnit()));
                    Glide.with(activity).load(currentForecast.getWeatherIconLink()).into(ivIcon);
                } else {
                    Log.d("Debug", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Hourly>> call, Throwable t) {
                Log.d("Debug", t.getMessage());
            }
        });
    }
}