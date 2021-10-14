package fhs.mmt.nma.umbrella.ui.weather.ui.current

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.FilterDrama
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Opacity
import androidx.compose.material.icons.outlined.Speed
import androidx.compose.material.icons.outlined.Thermostat
import androidx.compose.material.icons.outlined.Umbrella
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.Water
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material.icons.outlined.WbTwilight
import androidx.compose.material.icons.rounded.Air
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import fhs.mmt.nma.umbrella.R
import fhs.mmt.nma.umbrella.data.domain.CurrentWeather
import fhs.mmt.nma.umbrella.data.domain.DayWeather

data class WeatherFact(
    val label: String,
    val value: String,
    val icon: ImageVector,
)

@Composable
fun CurrentWeather.extractFacts() = listOf(
    WeatherFact(
        label = stringResource(id = R.string.temperature),
        value = "$maxTemperature°  |  $minTemperature°",
        icon = Icons.Outlined.Thermostat
    ),
    WeatherFact(
        label = stringResource(id = R.string.feels_like),
        value = "${hourWeather.apparentTemperature}°",
        icon = Icons.Outlined.Face
    ),
    WeatherFact(
        label = stringResource(id = R.string.wind_speed),
        value = "${hourWeather.windSpeed.toInt()} km/h",
        icon = Icons.Rounded.Air
    ),
    WeatherFact(
        label = stringResource(id = R.string.precipitation),
        value = "${(hourWeather.precipitation ?: 0.0).toInt()}%",
        icon = Icons.Outlined.Umbrella
    ),
    WeatherFact(
        label = stringResource(id = R.string.cloud_cover),
        value = "${(hourWeather.cloudCover).toInt()}%",
        icon = Icons.Outlined.FilterDrama
    ),
    WeatherFact(
        label = stringResource(id = R.string.humidity),
        value = "${(hourWeather.humidity).toInt()}%",
        icon = Icons.Outlined.Opacity
    ),
    WeatherFact(
        label = stringResource(id = R.string.pressure),
        value = "${hourWeather.pressure * 0.001} bar",
        icon = Icons.Outlined.Speed
    ),
    WeatherFact(
        label = stringResource(id = R.string.uv_index),
        value = "${hourWeather.uvIndex}",
        icon = Icons.Outlined.WbSunny
    ),
    WeatherFact(
        label = stringResource(id = R.string.weather_visibility),
        value = "${hourWeather.visibility / 1000} km",
        icon = Icons.Outlined.Visibility
    ),
    WeatherFact(
        label = stringResource(id = R.string.dew_point),
        value = "${hourWeather.dewPoint}°",
        icon = Icons.Outlined.Water
    ),
    WeatherFact(
        label = stringResource(id = R.string.sunrise),
        value = sunrise,
        icon = Icons.Outlined.LightMode
    ),
    WeatherFact(
        label = stringResource(id = R.string.sunset),
        value = sunset,
        icon = Icons.Outlined.WbTwilight
    ),
)

@Composable
fun DayWeather.extractFacts() = listOf(
    WeatherFact(
        label = stringResource(id = R.string.cloud_cover),
        value = "${(facts.cloudCover * 100).toInt()}%",
        icon = Icons.Outlined.FilterDrama
    ),
    WeatherFact(
        label = stringResource(id = R.string.wind_speed),
        value = "${facts.windSpeed.toInt()} km/h",
        icon = Icons.Rounded.Air
    ),
    WeatherFact(
        label = stringResource(id = R.string.humidity),
        value = "${(facts.humidity * 100).toInt()}%",
        icon = Icons.Outlined.Opacity
    ),
    WeatherFact(
        label = stringResource(id = R.string.uv_index),
        value = "${facts.uvIndex}",
        icon = Icons.Outlined.WbSunny
    ),
    WeatherFact(
        label = stringResource(id = R.string.sunrise),
        value = sunrise,
        icon = Icons.Outlined.LightMode
    ),
    WeatherFact(
        label = stringResource(id = R.string.sunset),
        value = sunset,
        icon = Icons.Outlined.WbTwilight
    ),
)
