package com.example.WeatherService.infra.gateway;

import com.example.WeatherService.core.dto.WeatherDto;

public interface OpenWeatherMapGateway {

    WeatherDto getWeatherByCityName(String cityName);
}
