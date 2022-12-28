package fhs.mmt.nma.pixie.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fhs.mmt.nma.pixie.data.Post
import fhs.mmt.nma.pixie.ui.theme.PixieTheme
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TopAppBar
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: HomeViewModel = viewModel()
    HomeScreenView(posts = viewModel.posts.value, onPostChange = {viewModel.onPostChanged(it)}, navController = navController)
}

@Composable
fun HomeScreenView(posts: List<Post>, onPostChange: (Post) -> Unit, navController: NavHostController) {
    Scaffold(
        topBar = { Header() },
        bottomBar = {  FooterToolbar() }) { innerPadding ->
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colors.background)
            ) {
                items(posts) {
                    PostCard(post = it, navController = navController)
                }
            }
    }
}
@Composable
fun Header(
    text : String = "Pixie"
) {
    TopAppBar(
        title = { Text(text,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .fillMaxWidth())},
        modifier = Modifier
            .height(64.dp)
            .shadow(4.dp, RectangleShape, true, MaterialTheme.colors.onSurface),
        backgroundColor = MaterialTheme.colors.surface)
}

@Composable
fun FooterToolbar() {
    var selectedItem by remember {
        mutableStateOf("Home")
    }
    val bottomNavigationItemsList  = listOf(
        LabeledIcon("Home", Icons.Filled.Home),
        LabeledIcon("Search", Icons.Filled.Search),
        LabeledIcon("Label", Icons.Filled.Bookmark),
        LabeledIcon("Profile", Icons.Filled.Person),
        LabeledIcon("Settings", Icons.Filled.Settings))

    BottomNavigation (
        modifier = Modifier
            .height(64.dp),
        backgroundColor = MaterialTheme.colors.surface){
        bottomNavigationItemsList.forEach { navItem ->
            BottomNavigationItem(
                onClick = { selectedItem = navItem.label },
                selected = (selectedItem == navItem.label),
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.label)
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onSurface)
        }
    }
}
data class LabeledIcon(val label: String, val icon: ImageVector)

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    PixieTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}



