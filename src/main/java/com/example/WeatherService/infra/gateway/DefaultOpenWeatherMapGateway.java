package com.example.WeatherService.infra.gateway;

import com.example.WeatherService.core.dto.WeatherDto;
import com.example.WeatherService.infra.connection.OpenWeatherMapConnection;
import com.example.WeatherService.infra.dto.OpenWeatherMapResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultOpenWeatherMapGateway implements OpenWeatherMapGateway{

    OpenWeatherMapConnection openWeatherMapConnection;

    @Autowired
    public DefaultOpenWeatherMapGateway(OpenWeatherMapConnection openWeatherMapConnection) {
        this.openWeatherMapConnection = openWeatherMapConnection;
    }

    @Override
    public WeatherDto getWeatherByCityName(String cityName) {
        WeatherDto weatherDto = new WeatherDto();
        OpenWeatherMapResponseDTO weatherByCityName = openWeatherMapConnection.getWeatherByCityName(cityName);
        weatherDto.setLocation(weatherByCityName.getName());
        weatherDto.setWeather(weatherByCityName.getWeather().getDescription());
        weatherDto.setTemperature(weatherByCityName.getMain().getTemp());
        return weatherDto;
    }
}
