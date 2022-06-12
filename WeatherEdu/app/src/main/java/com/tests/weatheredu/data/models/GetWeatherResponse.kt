package com.tests.weatheredu.data.models

data class GetWeatherResponse(
    val description: String,
    val forecast: List<Forecast>,
    val temperature: String,
    val wind: String
)