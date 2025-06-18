package com.example.weatherapp.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.weatherapp.Model.CurrentResponseApi;
import com.example.weatherapp.R;
import com.example.weatherapp.ViewModel.WeatherViewModel;
import com.example.weatherapp.databinding.ActivityMainBinding;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private WeatherViewModel weatherViewModel;
    private Calendar calendar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        calendar= Calendar.getInstance();
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        initData();


    }

    private void initData() {

        double lat =105.99;
        double lon = 21.34;
        String name = "London";

        binding.tvCity.setText(name);
        binding.progressCircular.setVisibility(View.VISIBLE);

        weatherViewModel.loadCurrentWeather(lat, lon, "metric")
                .enqueue(new Callback<>() {

                    @Override
                    public void onResponse(@NonNull Call<CurrentResponseApi> call, @NonNull Response<CurrentResponseApi> response) {

                        if(response.isSuccessful()){
                            CurrentResponseApi  data = response.body();
                            binding.progressCircular.setVisibility(View.GONE);

                            if (data != null) {
                                binding.layoutDetail.setVisibility(View.VISIBLE);

                                // Gán giá trị status
                                String weatherMain = "-";
                                if (data.getWeather() != null && !data.getWeather().isEmpty() && data.getWeather().get(0).getMain() != null) {
                                    weatherMain = data.getWeather().get(0).getMain();
                                }
                                binding.tvSateWeather.setText(weatherMain);

                                // Gió
                                if (data.getWind() != null && data.getWind().getSpeed() != null) {
                                    binding.tvValueWind.setText(Math.round(data.getWind().getSpeed()) + " km");
                                }

                                if (data.getMain() != null && data.getMain().getHumidity() != null) {
                                    binding.tvValueHumidity.setText(Math.round(data.getMain().getHumidity()) + " %");
                                }


                                // Nhiệt độ hiện tại
                                if (data.getMain() != null && data.getMain().getTemp() != null) {
                                    binding.tvValueTemp.setText(Math.round(data.getMain().getTemp()) + "°");
                                }

                                // Nhiệt độ max
                                if (data.getMain().getTempMax() != null) {
                                    binding.tvTempMax.setText(Math.round(data.getMain().getTempMax()) + "°");
                                }

                                // Nhiệt độ min
                                if (data.getMain().getTempMin() != null) {
                                    binding.tvTempMin.setText(Math.round(data.getMain().getTempMin()) + "°");
                                }

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
                                    setWeatherIcon(data.getWeather().getFirst().getIcon(),binding.imgBg );
                                }


                                if (data.getName() != null) {
                                    binding.tvCity.setText(data.getName());
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<CurrentResponseApi> call, @NonNull Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });


    }

    private boolean isNightNow(){
        return calendar.get(Calendar.HOUR_OF_DAY)>=18;
    }


    private void setWeatherIcon(String icon, ImageView weatherIcon) {
        if (icon == null || icon.length() < 2 || weatherIcon == null) {
            assert weatherIcon != null;
            weatherIcon.setImageResource(R.drawable.sunny_bg);
            return;
        }

        String code = icon.substring(0, icon.length() - 1); // Lấy mã thời tiết (VD: "01", "02")
        boolean isNight = icon.endsWith("n"); // Kiểm tra là ban đêm không

        int iconRes;

        switch (code) {
            case "01": // Trời quang
                iconRes = isNight ? R.drawable.night_bg : R.drawable.sunny_bg;
                break;

            case "02":
            case "03":
            case "04": // Có mây
                iconRes = isNight ? R.drawable.sunny_bg : R.drawable.cloudy_bg;
                break;

            case "09": // Mưa nhỏ
            case "10": // Mưa vừa
            case "11": // Dông
                iconRes = R.drawable.rainy_bg;
                break;

            case "13": // Tuyết
                iconRes = R.drawable.snow_bg;
                break;

            case "50": // Sương mù
                iconRes = R.drawable.cloudy_bg;
                break;

            default:
                iconRes = R.drawable.sunny_bg;
                break;
        }

        weatherIcon.setImageResource(iconRes);
    }

}