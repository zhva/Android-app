package fhs.mmt.nma.umbrella.ui.weather.ui.day

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Thermostat
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fhs.mmt.nma.umbrella.R
import fhs.mmt.nma.umbrella.data.domain.DayWeather
import fhs.mmt.nma.umbrella.ui.weather.ui.current.WeatherFact
import fhs.mmt.nma.umbrella.ui.samples.WeatherFactsSample
import fhs.mmt.nma.umbrella.ui.weather.ui.current.extractFacts
import fhs.mmt.nma.umbrella.ui.weather.description
import fhs.mmt.nma.umbrella.ui.weather.icon
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun DayWeather(item: DayWeather) {
    val dateFormat = SimpleDateFormat("EEEE d")
    var expanded by rememberSaveable { mutableStateOf(false) }
    val rotation: Float by animateFloatAsState(if (expanded) 180f else 0f)

    Column(modifier = Modifier.animateContentSize()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(item.facts.state.icon()),
                    contentDescription = stringResource(id = item.facts.state.description),
                    modifier = Modifier.size(56.dp)
                )
                Spacer(Modifier.width(16.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = dateFormat.format(item.date).capitalize(),
                        style = MaterialTheme.typography.h2,
                    )
                    Spacer(Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.Thermostat,
                            contentDescription = stringResource(R.string.temperature),
                            modifier = Modifier.size(16.dp),
                            tint = MaterialTheme.colors.primary
                        )
                        Spacer(Modifier.width(4.dp))
                        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                            Text(
                                text = "${item.maxTemperature}°  |  ${item.minTemperature}°",
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier
                            )
                        }
                        Spacer(Modifier.width(16.dp))
                        Icon(
                            painter = painterResource(R.drawable.ic_rain),
                            contentDescription = stringResource(R.string.precipitation),
                            modifier = Modifier.size(22.dp),
                            tint = MaterialTheme.colors.primary
                        )
                        Spacer(Modifier.width(4.dp))
                        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                            Text(
                                text = "${item.facts.precipitation}%",
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier
                            )
                        }
                    }
                }
            }

            Icon(
                imageVector = Icons.Rounded.ExpandMore,
                contentDescription = stringResource(id = R.string.expandable_header_toggle_message),
                modifier = Modifier
                    .size(28.dp)
                    .rotate(rotation),
            )
        }

        if (expanded) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(LocalContentColor.current.copy(alpha = 0.06f))
            ) {
                Text(
                    text = stringResource(id = item.facts.state.description),
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 20.dp)
                )

                val weatherFacts = item.extractFacts()

                val itemsPerRow = 2
                weatherFacts.chunked(itemsPerRow)
                    .run { if (!expanded) take(2) else this }
                    .forEach { factsPerRow ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            factsPerRow.forEachIndexed { index, fact ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(1f / (itemsPerRow - index))
                                ) {
                                    WeatherFact(fact)
                                }
                            }
                        }
                    }
            }
        }
    }
}

@Preview
@Composable
fun DayWeatherPreview() {
    val item = DayWeather(
        date = Date(),
        facts = WeatherFactsSample,
        sunrise = "06:44",
        sunset = "18:54",
        minTemperature = 4,
        maxTemperature = 21,
    )

    DayWeather(item)
}