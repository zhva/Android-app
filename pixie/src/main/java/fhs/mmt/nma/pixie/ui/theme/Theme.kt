package fhs.mmt.nma.pixie.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PixieTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    MaterialTheme(
        content = content,
        colors = if (darkTheme) PixieDarkColors else PixieLightColors,
        typography = PixieTypography
    )
}