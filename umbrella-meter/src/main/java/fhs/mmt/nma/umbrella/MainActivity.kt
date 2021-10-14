package fhs.mmt.nma.umbrella

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import fhs.mmt.nma.umbrella.ui.UmbrellaNavigation
import fhs.mmt.nma.umbrella.ui.theme.UmbrellaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UmbrellaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    UmbrellaNavigation()
                }
            }
        }
    }
}
