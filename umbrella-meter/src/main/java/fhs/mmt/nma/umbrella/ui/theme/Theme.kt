package fhs.mmt.nma.umbrella.ui.theme

import Gray800
import Gray900
import Rust300
import Rust600
import White
import White150
import White800
import White850
import Yellow
import Yellow500
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Yellow,
    secondary = Rust300,
    onSecondary = Gray900,
    onPrimary = Gray900,
    surface = White150,
    background = Gray900,
    onSurface = White800
)

private val LightColorPalette = lightColors(
    primary = Yellow500,
    secondary = Rust600,
    onSecondary = White,
    onPrimary = White,
    surface = White850,
    background = White,
    onSurface = Gray800
)

@Composable
fun UmbrellaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}