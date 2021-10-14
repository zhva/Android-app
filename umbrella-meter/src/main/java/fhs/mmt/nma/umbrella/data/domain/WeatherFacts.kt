package fhs.mmt.nma.umbrella.data.domain

data class WeatherFacts(
    val temperature: Double,
    val apparentTemperature: Double,
    val precipitation: Double?,
    val humidity: Double,
    val windSpeed: Double,
    val cloudCover: Double,
    val pressure: Double,
    val visibility: Double,
    val uvIndex: Int,
    val dewPoint: Int,
    val state: WeatherState,
)