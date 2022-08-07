package com.example.demo.elementsForResponses;

public class Weather {
    private String cityName;
    private double temperature;
    private String state;
    public Weather() {
    }

    public Weather(String cityName, double temperature) {
        this.cityName = cityName;
        this.temperature = temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Today weather in " +
                cityName +
                " is " +
                state +
                " and temperature is " +
                temperature;
    }
}
