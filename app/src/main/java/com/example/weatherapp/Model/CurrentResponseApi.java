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

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
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

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

public static class Wind {
    @SerializedName("deg")
    public Integer deg;

    @SerializedName("gust")
    public Double gust;

    @SerializedName("speed")
    public Double speed;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
