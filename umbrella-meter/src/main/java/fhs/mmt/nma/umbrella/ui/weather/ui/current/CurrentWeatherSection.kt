package fhs.mmt.nma.umbrella.ui.weather.ui.current

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fhs.mmt.nma.umbrella.R
import fhs.mmt.nma.umbrella.data.domain.CurrentWeather
import fhs.mmt.nma.umbrella.ui.samples.CurrentWeatherSample
import fhs.mmt.nma.umbrella.ui.theme.UmbrellaTheme
import fhs.mmt.nma.umbrella.ui.weather.ExpandableSectionHeader


@Composable
fun CurrentWeatherSection(currentWeather: CurrentWeather, itemsPerRow: Int = 2) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        ExpandableSectionHeader(
            title = stringResource(id = R.string.details),
            subtitle = stringResource(id = R.string.weather_now),
            expanded = expanded,
            onToggleState = { expanded = !expanded }
        )
        Spacer(Modifier.height(8.dp))

        val weatherFacts = currentWeather.extractFacts()

        weatherFacts.chunked(itemsPerRow)
            .run { if (!expanded) take(2) else this }
            .forEach { factsPerRow ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    factsPerRow.forEachIndexed { index, fact ->
                        WeatherFact(
                            item = fact,
                            modifier = Modifier.fillMaxWidth(1f / (itemsPerRow - index))
                        )
                    }

                }
            }
    }
}

@Preview
@Composable
fun CurrentWeatherPreview() {
    UmbrellaTheme {
        CurrentWeatherSection(CurrentWeatherSample)
    }
}