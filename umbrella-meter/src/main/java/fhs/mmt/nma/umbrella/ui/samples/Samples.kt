package fhs.mmt.nma.umbrella.ui.samples

import fhs.mmt.nma.umbrella.data.domain.CurrentWeather
import fhs.mmt.nma.umbrella.data.domain.DayWeather
import fhs.mmt.nma.umbrella.data.domain.Location
import fhs.mmt.nma.umbrella.data.domain.WeatherFacts
import fhs.mmt.nma.umbrella.data.domain.WeatherState
import java.util.Calendar
import java.util.Date

val Today = createToday().time

fun createToday() = Calendar.getInstance().also {
    it[Calendar.MINUTE] = 0
    it[Calendar.SECOND] = 0
    it[Calendar.MILLISECOND] = 0
}

val Tomorrow = createToday().nextDay()

fun Calendar.plusDays(days: Int): Date {
    add(Calendar.DAY_OF_YEAR, days)
    return time
}

fun Calendar.nextDay() = plusDays(1)


fun createWeatherFacts(state: WeatherState = WeatherState.CLEAR_SKY) = WeatherFacts(
    temperature = 2.0,
    apparentTemperature = 2.0,
    precipitation = 0.2,
    humidity = 0.49,
    windSpeed = 17.0,
    cloudCover = 0.88,
    pressure = 1.0,
    visibility = 5.0,
    uvIndex = 1,
    dewPoint = -4,
    state = state
)

val WeatherFactsSample = createWeatherFacts()

val CurrentWeatherSample = CurrentWeather(
    time = Today,
    hourWeather = WeatherFactsSample,
    sunrise = "06:46",
    sunset = "18:53",
    minTemperature = -1,
    maxTemperature = 9
)

fun createDayWeather(date: Date = Tomorrow, weatherState: WeatherState = WeatherState.CLEAR_SKY) =
    DayWeather(
        date = date,
        facts = createWeatherFacts(weatherState),
        sunrise = "06:46",
        sunset = "18:53",
        minTemperature = -1,
        maxTemperature = 9,
    )


val DayWeatherSample = createDayWeather()

val WeekWeatherSample = List(WeatherState.values().size) {
    createDayWeather(date = createToday().plusDays(it + 1), weatherState = WeatherState.values()[it])
}

val LocationSample =  Location(
    name = "Munich",
    latitude = 48.137154,
    longitude = 11.576124,
    country = "Germany"
)
