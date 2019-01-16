package com.example.WeatherService.infra.connection;

import com.example.WeatherService.infra.dto.OpenWeatherMapResponseDTO;

public interface OpenWeatherMapConnection {

    OpenWeatherMapResponseDTO getWeatherByCityName(String cityName);
}
