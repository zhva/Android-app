package fhs.mmt.nma.umbrella.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import fhs.mmt.nma.umbrella.ui.locations.LocationSearchScreen
import fhs.mmt.nma.umbrella.ui.weather.ui.WeatherScreen

@Composable
@OptIn(ExperimentalMaterialNavigationApi::class)
fun UmbrellaNavigation() {

    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController(bottomSheetNavigator)

    ModalBottomSheetLayout(bottomSheetNavigator) {

        NavHost(navController = navController, startDestination = "weather") {

            composable("weather") {
                WeatherScreen(viewModel = viewModel(it), navController = navController)
            }

            bottomSheet("locations") {
                LocationSearchScreen(viewModel = viewModel(it), navController = navController)
            }

        }
    }
}