package fhs.mmt.nma.umbrella.ui.weather.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import fhs.mmt.nma.umbrella.R
import fhs.mmt.nma.umbrella.data.domain.CurrentWeather
import fhs.mmt.nma.umbrella.data.domain.DayWeather
import fhs.mmt.nma.umbrella.data.domain.Location
import fhs.mmt.nma.umbrella.ui.samples.CurrentWeatherSample
import fhs.mmt.nma.umbrella.ui.samples.LocationSample
import fhs.mmt.nma.umbrella.ui.samples.WeekWeatherSample
import fhs.mmt.nma.umbrella.ui.theme.UmbrellaTheme
import fhs.mmt.nma.umbrella.ui.weather.SectionHeader
import fhs.mmt.nma.umbrella.ui.weather.WeatherViewModel
import fhs.mmt.nma.umbrella.ui.weather.description
import fhs.mmt.nma.umbrella.ui.weather.icon
import fhs.mmt.nma.umbrella.ui.weather.ui.current.CurrentWeatherSection
import fhs.mmt.nma.umbrella.ui.weather.ui.day.DayWeather
import kotlin.math.roundToInt

@Composable
fun WeatherScreen(viewModel: WeatherViewModel, navController: NavController) {
    //TODO: Read Data from ViewModel

    WeatherScreen(
        location = LocationSample,
        currentWeather = CurrentWeatherSample,
        weeklyWeather = WeekWeatherSample,
        navController = navController
    )

}

@Composable
fun WeatherScreen(
    location: Location,
    currentWeather: CurrentWeather,
    weeklyWeather: List<DayWeather>,
    navController: NavController
) {
    LazyColumn {

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    TextButton(onClick = { navController.navigate("locations") }) {
                        Text(location.name)
                        Icon(imageVector = Icons.Default.ExpandMore, contentDescription = null)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(
                            painter = painterResource(id = currentWeather.hourWeather.state.icon()),
                            contentDescription = currentWeather.hourWeather.state.name
                        )
                        Text(stringResource(id = currentWeather.hourWeather.state.description), style = MaterialTheme.typography.h2)
                    }
                }
                Temperature(currentWeather.hourWeather.temperature)
            }
        }

        item { CurrentWeatherSection(currentWeather = currentWeather) }

        item {
            SectionHeader(
                title = stringResource(R.string.this_week),
                subtitle = stringResource(R.string.forecast_7days)
            )
        }

        items(weeklyWeather) { item ->
            DayWeather(item)
        }

    }
}

@Composable
fun Temperature(temperature: Double) {

    val textShadow = Shadow(
        offset = Offset(5f, 5f),
        blurRadius = 5f
    )

    Row {
        Text(
            text = "${temperature.roundToInt()}",
            style = MaterialTheme.typography.h1.copy(
                fontSize = 60.sp,
                shadow = textShadow
            )
        )
        Text(
            text = "°C",
            style = MaterialTheme.typography.h1.copy(
                shadow = textShadow
            )
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun WeatherScreenPreview() {

    UmbrellaTheme {
        WeatherScreen(
            location = LocationSample,
            currentWeather = CurrentWeatherSample,
            weeklyWeather = WeekWeatherSample,
            navController = rememberNavController()
        )
    }
}