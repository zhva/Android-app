package fhs.mmt.nma.umbrella.data.domain

import java.util.Date

data class CurrentWeather(
    val time: Date,
    val hourWeather: WeatherFacts,
    val sunrise: String,
    val sunset: String,
    val minTemperature: Int,
    val maxTemperature: Int,
)