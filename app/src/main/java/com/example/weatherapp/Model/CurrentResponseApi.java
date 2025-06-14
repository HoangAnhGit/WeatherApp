package com.example.weatherapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentResponseApi {

@SerializedName("base")
public String base;

@SerializedName("clouds")
public Clouds clouds;

@SerializedName("cod")
public Integer cod;

@SerializedName("coord")
public Coord coord;

@SerializedName("dt")
public Integer dt;

@SerializedName("id")
public Integer id;

@SerializedName("main")
public Main main;

@SerializedName("name")
public String name;

@SerializedName("rain")
public Rain rain;

@SerializedName("sys")
public Sys sys;

@SerializedName("timezone")
public Integer timezone;

@SerializedName("visibility")
public Integer visibility;

@SerializedName("weather")
public List<Weather> weather;

@SerializedName("wind")
public Wind wind;

public static class Clouds {
    @SerializedName("all")
    public Integer all;
}

public static class Coord {
    @SerializedName("lat")
    public Double lat;

    @SerializedName("lon")
    public Double lon;
}

public static class Main {
    @SerializedName("feels_like")
    public Double feelsLike;

    @SerializedName("grnd_level")
    public Integer grndLevel;

    @SerializedName("humidity")
    public Integer humidity;

    @SerializedName("pressure")
    public Integer pressure;

    @SerializedName("sea_level")
    public Integer seaLevel;

    @SerializedName("temp")
    public Double temp;

    @SerializedName("temp_max")
    public Double tempMax;

    @SerializedName("temp_min")
    public Double tempMin;
}

public static class Rain {
    @SerializedName("1h")
    public Double h;
}

public static class Sys {
    @SerializedName("country")
    public String country;

    @SerializedName("id")
    public Integer id;

    @SerializedName("sunrise")
    public Integer sunrise;

    @SerializedName("sunset")
    public Integer sunset;

    @SerializedName("type")
    public Integer type;
}

public static class Weather {
    @SerializedName("description")
    public String description;

    @SerializedName("icon")
    public String icon;

    @SerializedName("id")
    public Integer id;

    @SerializedName("main")
    public String main;
}

public static class Wind {
    @SerializedName("deg")
    public Integer deg;

    @SerializedName("gust")
    public Double gust;

    @SerializedName("speed")
    public Double speed;
}
}
