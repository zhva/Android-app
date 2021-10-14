import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val Gray800 = Color(0xCC333333)
val Gray900 = Color(0xff333333)
val Rust300 = Color(0xFFE1AFAF)
val Rust600 = Color(0xFF886363)
val Taupe100 = Color(0xfff0EAE2)
val Taupe800 = Color(0xff655454)
val White150 = Color(0x26FFFFFF)
val White800 = Color(0xCCFFFFFF)
val White850 = Color(0xD9FFFFFF)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Yellow = Color(0xFFFFCF44)
val Yellow500 = Color(0xFFF5BD1C)
val Purple = Color(0XFF4A22A8)
val DarkBlue = Color(0XFF0E0F6D)
val Blue = Color(0XFF1753CE)
val SkyBlue = Color(0XFF6691CB)
val Sand = Color(0XFFD7975A)
val Snow = Color(0xFF7C706A)
val DarkGrey = Color(0xFF444444)

@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}