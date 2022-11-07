package fhs.mmt.nma.pixie.ui.theme

import android.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun PixieTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    MaterialTheme(
        content = content,
        colors = if (darkTheme) PixieDarkColors else PixieLightColors

    )
}