package fhs.mmt.nma.umbrella.data.domain

import java.util.Date

data class DayWeather(
    val date: Date,
    val facts: WeatherFacts,
    val sunrise: String,
    val sunset: String,
    val minTemperature: Int,
    val maxTemperature: Int,
)