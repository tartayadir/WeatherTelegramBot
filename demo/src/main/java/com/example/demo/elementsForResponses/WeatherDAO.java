package com.example.demo.elementsForResponses;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@Component
public class WeatherDAO {

    private static String weatherToken = "1e6c060b823e36d642cb303a161a8efd";

    public static String getWhether(String cityName) throws IOException {

        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + cityName +
                "&units=metric&appid=" + weatherToken);
        Weather weather = new Weather();
        Scanner scanner = new Scanner((InputStream) url.getContent());
        StringBuilder result = new StringBuilder("");

        while (scanner.hasNext()){
            result.append(scanner.nextLine());
        }

        JSONObject jsonObject = new JSONObject(result.toString());
        weather.setCityName(cityName);

        JSONObject main = jsonObject.getJSONObject("main");
        weather.setTemperature(main.getDouble("temp"));

        JSONArray weatherJSON = jsonObject.getJSONArray("weather");
        String weatherDescription = weatherJSON.getJSONObject(0).getString("description");
        String state = switch (weatherDescription){
            case "clear sky" -> "☀️";
            case "few clouds" -> "⛅️";
            case "scattered clouds", "overcast clouds" -> "☁️";
            case "broken clouds" -> "\uD83C\uDF29";
            case "shower rain" -> "\uD83C\uDF27";
            case "rain" -> "\uD83C\uDF26";
            case "thunderstorm" -> "\uD83C\uDF29";
            case "snow" -> "\uD83C\uDF28";
            case "mist" -> "\uD83C\uDF2B";
            default -> "null";
        };
        weather.setState(state);

        return weather.toString();
    }
}
