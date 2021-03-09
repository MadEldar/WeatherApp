package com.example.weatherappbyhai;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherappbyhai.models.Daily;
import com.example.weatherappbyhai.models.DailyForecast;

import java.text.SimpleDateFormat;
import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<DailyForecast> listData;

    public DailyAdapter(Activity activity, List<DailyForecast> listData) {
        this.activity = activity;
        this.listData = listData;
    }

    public void reloadData(List<DailyForecast> list) {
        listData = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_daily, parent, false);
        return new DailyHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DailyForecast model = listData.get(position);
        DailyHolder vh = (DailyHolder) holder;
        SimpleDateFormat sdf = new SimpleDateFormat("EEE");
        vh.tvDate.setText(sdf.format(model.getDate()));
        vh.tvMinimumTemp.setText(String.valueOf(model.getTemperature().getMinimum().getValue()));
        vh.tvMaximumTemp.setText(String.valueOf(model.getTemperature().getMaximum().getValue()));
        vh.tvUnit.setText(model.getTemperature().getMinimum().getUnit());
        vh.tvDayIconPhrase.setText(model.getDay().getIconPhrase());
        vh.tvNightIconPhrase.setText(model.getNight().getIconPhrase());
        Glide.with(activity).load(model.getDay().getIconLink()).into(vh.ivDayIcon);
        Glide.with(activity).load(model.getNight().getIconLink()).into(vh.ivNightIcon);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class DailyHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvMinimumTemp, tvMaximumTemp, tvUnit, tvDayIconPhrase, tvNightIconPhrase;
        ImageView ivDayIcon, ivNightIcon;

        public DailyHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvMinimumTemp = itemView.findViewById(R.id.tvMinimumTemp);
            tvMaximumTemp = itemView.findViewById(R.id.tvMaximumTemp);
            tvUnit = itemView.findViewById(R.id.tvUnit);
            tvDayIconPhrase = itemView.findViewById(R.id.tvDayIconPhrase);
            tvNightIconPhrase = itemView.findViewById(R.id.tvNightIconPhrase);
            ivDayIcon = itemView.findViewById(R.id.ivDayIcon);
            ivNightIcon = itemView.findViewById(R.id.ivNightIcon);
        }
    }
}
