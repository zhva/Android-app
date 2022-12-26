package fhs.mmt.nma.pixie.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Purple100 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF80CBC4)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Grey = Color(0xFFECECEC)
val Grey800 = Color(0xFF424242)
val Grey900 = Color(0xFF121212)

val PixieDarkColors = darkColors(
    primary = Purple100,
    primaryVariant = Purple700,
    secondary = Teal200,
    onPrimary = Black,
    background = Grey900,
    onBackground = White,
    surface = Grey800,
    onSurface = White,
    onError = Grey
)
val PixieLightColors = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
    onPrimary = White,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
    onError = Grey
)
