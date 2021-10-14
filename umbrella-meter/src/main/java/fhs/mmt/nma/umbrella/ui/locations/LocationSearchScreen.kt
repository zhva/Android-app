package fhs.mmt.nma.umbrella.ui.locations

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import fhs.mmt.nma.umbrella.R
import fhs.mmt.nma.umbrella.data.domain.Location
import fhs.mmt.nma.umbrella.ui.samples.LocationSample
import fhs.mmt.nma.umbrella.ui.theme.UmbrellaTheme

@Composable
fun LocationSearchScreen(viewModel: LocationSearchViewModel, navController: NavController) {

    val loading = true //TODO: Read from ViewModel instead

    val results = List(20) { LocationSample } //TODO: Read from ViewModel

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                },
                title = { Text(stringResource(id = R.string.change_location)) },
                backgroundColor = MaterialTheme.colors.surface,
            )
        },
        content = {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                item {
                    Button(
                        onClick = { /* TODO: Send to ViewModel*/ },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(imageVector = Icons.Default.MyLocation, contentDescription = null)
                        Spacer(Modifier.size(8.dp))
                        Text(text = stringResource(id = R.string.use_current_location))
                    }
                }

                item {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "", //TODO
                        onValueChange = { /* TODO: Send to ViewModel */ },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                    )
                }

                if (loading) {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize()
                        )
                    }
                }

                items(results) {
                    LocationResult(
                        location = it,
                        onClick = { /* TODO: Send to ViewModel */ }
                    )
                }


            }
        }
    )
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun LocationResult(location: Location, onClick: () -> Unit) {
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = location.name, style = MaterialTheme.typography.h1)
            Text(text = location.country, style = MaterialTheme.typography.caption)
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun LocationSearchScreenPreview() {

    UmbrellaTheme {
        LocationSearchScreen(
            viewModel = LocationSearchViewModel(),
            navController = rememberNavController()
        )
    }
}