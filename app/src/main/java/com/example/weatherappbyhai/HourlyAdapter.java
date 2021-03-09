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
import com.example.weatherappbyhai.models.Hourly;

import java.util.List;

public class HourlyAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<Hourly> listData;

    public HourlyAdapter(Activity activity, List<Hourly> listData) {
        this.activity = activity;
        this.listData = listData;
    }

    public void reloadData(List<Hourly> list) {
        listData = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_hourly, parent, false);
        return new HourlyHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Hourly model = listData.get(position);
        HourlyHolder vh = (HourlyHolder) holder;
        int hour = model.getDateTime().getHours();
        vh.tvTime.setText(hour > 12 ? String.format("%dpm", hour - 12) : String.format("%dam", hour));
        vh.tvTemperature.setText(String.valueOf(model.getTemperature().getValue()));

        vh.tvUnit.setText(model.getTemperature().getUnit());
        Glide.with(activity).load(model.getWeatherIconLink()).into(vh.ivIcon);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HourlyHolder extends RecyclerView.ViewHolder {
        TextView tvTime, tvTemperature, tvUnit;
        ImageView ivIcon;

        public HourlyHolder(@NonNull View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvTemperature = itemView.findViewById(R.id.tvTemperature);
            tvUnit = itemView.findViewById(R.id.tvUnit);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
}
