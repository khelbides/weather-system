package com.example.WeatherService.ui;

import com.example.WeatherService.core.dto.WeatherDto;
import com.example.WeatherService.core.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class WeatherServiceController {

    private final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceController.class);

    private WeatherService weatherService;

    public WeatherServiceController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<List<WeatherDto>> displayWeatherLondonPragueSanFrancisco()
    {
        LOGGER.info("START - Getting weather information for London, Prague and San Francisco");
        List<WeatherDto> response = weatherService.getWeatherInfoOfLondonPragueSanFrancisco();
        LOGGER.info("END - Getting weather information for London, Prague and San Francisco");
        return ResponseEntity.ok(response);
    }
}
