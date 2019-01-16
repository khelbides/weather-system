package com.example.WeatherService.infra.dto;

public class CloudsDTO {
    String all;

    @Override
    public String toString() {
        return "CloudsDTO{" +
                "all='" + all + '\'' +
                '}';
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }
}
