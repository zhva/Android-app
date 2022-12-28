package fhs.mmt.nma.pixie.ui.profile

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PermMedia
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import fhs.mmt.nma.pixie.data.Photographer
import fhs.mmt.nma.pixie.data.Photography
import fhs.mmt.nma.pixie.samples.AllPosts
import fhs.mmt.nma.pixie.samples.AllUsers
import fhs.mmt.nma.pixie.samples.providers.UserSampleProvider
import fhs.mmt.nma.pixie.ui.home.ImageLoader
import fhs.mmt.nma.pixie.ui.home.getFormattedNumber
import fhs.mmt.nma.pixie.ui.theme.PixieTheme


@Composable
fun ProfileScreen(userId: String, navController: NavHostController) {
    val user = AllUsers.find { it.id == userId.toInt() }
    val userPosts = AllPosts.filter { it.author.id == userId.toInt() }
    var photos = ArrayList<Photography>()
    userPosts.forEach { post -> photos.addAll(post.photos) }
    photos = photos.distinct() as ArrayList<Photography>
    var comments = 0
    userPosts.forEach { post -> comments += post.comments.size }
    var likes = 0
    userPosts.forEach { post -> likes += post.likes }

    Scaffold(
        topBar = { UserProfileHeader(user?.name ?: "Empty", navController = navController) },
        bottomBar = {}
    ) { innerPadding ->
        LazyVerticalGrid(
            columns  = GridCells.Fixed(3),
            contentPadding = PaddingValues(top = innerPadding.calculateTopPadding() + 24.dp, start = 8.dp, end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp)){
            item(span = { GridItemSpan(maxLineSpan)}) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(user?.picture),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(shape = CircleShape)
                                .border(
                                    width = 1.5.dp,
                                    shape = CircleShape,
                                    color = MaterialTheme.colors.primary
                                )
                        )
                        ProfileInformation(likes, "Likes")
                        ProfileInformation(photos.size, "Photos")
                        ProfileInformation(comments, "Comments")
                    }
                    Text(
                        text = user?.name ?: "No Name",
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        InfoBlock(user?.location, "Location", Icons.Filled.LocationOn)
                        InfoBlock(user?.instagram, "Social", Icons.Filled.PermMedia)
                    }
                    Text(
                        text = user?.bio ?: "NoBio",
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
            items(photos.size) { index ->
                Box( modifier = Modifier
                    .size(LocalConfiguration.current.screenWidthDp.dp / 3 - 16.dp)) {
                    ImageLoader(imgUrl = photos[index].url)
                }
            }

        }
    }
}

@Composable
fun ProfileInformation(num: Int, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = getFormattedNumber(num), style = MaterialTheme.typography.h2)
        Text(text = text, style = MaterialTheme.typography.caption)
    }
}
@Composable fun InfoBlock(info: String?, contentDescr: String, icon: ImageVector) {
    val context = LocalContext.current
    if (!info.isNullOrEmpty()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(
                onClick = {
                          if(contentDescr == "Social") {
                              openInstagram(info, context)
                          }
                },
                modifier = Modifier.height(32.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colors.onSurface
                )
            ) {
                Icon(
                    icon,
                    contentDescription = contentDescr,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = info.toString(),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

fun openInstagram(userProfile: String?, context: Context) {
    val likeIng = Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/${userProfile}"))
    likeIng.setPackage("com.instagram.android")
    try {
        startActivity(context, likeIng, null)
    } catch (e: ActivityNotFoundException) {
        startActivity(context, Intent( Intent.ACTION_VIEW, Uri.parse("http://instagram.com/${userProfile}")), null)
    }
}

@Composable
fun UserProfileHeader(userName: String, navController: NavHostController) {
    TopAppBar(
        title = {
            Text(userName,style = MaterialTheme.typography.h1)},
        modifier = Modifier
            .height(64.dp)
            .shadow(4.dp, RectangleShape, true, MaterialTheme.colors.onSurface),
        backgroundColor = MaterialTheme.colors.surface,
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Outlined.ArrowBack, null)
            }
        },
        actions = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Outlined.MoreVert,
                    null,
                    tint = MaterialTheme.colors.onSurface
                )
            }
        })
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfilePreview(@PreviewParameter(UserSampleProvider::class) user: Photographer) {
    PixieTheme {
        val navController = rememberNavController()
        ProfileScreen(userId = user.id.toString(), navController)
    }
}

