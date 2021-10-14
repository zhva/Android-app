package fhs.mmt.nma.umbrella.ui.weather

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import fhs.mmt.nma.umbrella.R
import fhs.mmt.nma.umbrella.data.domain.WeatherState

inline val WeatherState.description: Int
    @StringRes
    get() = when (this) {
        WeatherState.CLEAR_SKY -> R.string.clear_sky
        WeatherState.FEW_CLOUDS -> R.string.few_clouds
        WeatherState.SCATTERED_CLOUDS -> R.string.scattered_clouds
        WeatherState.MOSTLY_CLOUDY -> R.string.mostly_cloudy
        WeatherState.RAIN -> R.string.rainy
        WeatherState.HEAVY_RAIN -> R.string.heavy_rain
        WeatherState.THUNDERSTORM -> R.string.thunderstorm
        WeatherState.SNOW -> R.string.snowy
        WeatherState.FOG -> R.string.foggy
    }

@DrawableRes
fun WeatherState.icon(nightMode: Boolean = false): Int = when (this) {
    WeatherState.CLEAR_SKY -> if (nightMode) R.drawable.ic_night_clear else R.drawable.ic_sunny
    WeatherState.FEW_CLOUDS -> if (nightMode) R.drawable.ic_night_alt_partly_cloudy else R.drawable.ic_day_sunny_overcast
    WeatherState.SCATTERED_CLOUDS -> if (nightMode) R.drawable.ic_night_alt_cloudy else R.drawable.ic_day_cloudy
    WeatherState.MOSTLY_CLOUDY -> R.drawable.ic_cloudy
    WeatherState.RAIN -> if (nightMode) R.drawable.ic_night_alt_showers else R.drawable.ic_day_showers
    WeatherState.HEAVY_RAIN -> if (nightMode) R.drawable.ic_night_alt_rain else R.drawable.ic_day_rain
    WeatherState.THUNDERSTORM -> if (nightMode) R.drawable.ic_night_alt_thunderstorm else R.drawable.ic_day_thunderstorm
    WeatherState.SNOW -> if (nightMode) R.drawable.ic_night_alt_snow else R.drawable.ic_day_snow
    WeatherState.FOG -> if (nightMode) R.drawable.ic_night_fog else R.drawable.ic_day_fog
}
