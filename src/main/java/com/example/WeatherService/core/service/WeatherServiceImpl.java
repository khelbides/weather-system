package com.example.WeatherService.core.service;

import com.example.WeatherService.core.dto.WeatherDto;
import com.example.WeatherService.infra.gateway.OpenWeatherMapGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements  WeatherService{

    private OpenWeatherMapGateway openWeatherMapGateway;

    @Autowired
    public WeatherServiceImpl(OpenWeatherMapGateway openWeatherMapGateway) {
        this.openWeatherMapGateway = openWeatherMapGateway;
    }

    @Override
    public WeatherDto getWeatherInfoByCityName(String cityName)
    {
        return openWeatherMapGateway.getWeatherByCityName(cityName);
    }

    @Override
    public List<WeatherDto> getWeatherInfoByCityNames(List<String> cityNameList) {
        return cityNameList.stream().map(this::getWeatherInfoByCityName).collect(Collectors.toList());
    }

    @Override
    public List<WeatherDto> getWeatherInfoOfLondonPragueSanFrancisco() {
        List<String> cityNames = new ArrayList<>(Arrays.asList("London", "Prague", "San Francisco"));
        return getWeatherInfoByCityNames(cityNames);
    }
}
