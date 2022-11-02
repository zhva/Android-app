package fhs.mmt.nma.pixie.ui.home

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fhs.mmt.nma.pixie.data.Post
import fhs.mmt.nma.pixie.samples.providers.PostSampleProvider
import fhs.mmt.nma.pixie.ui.theme.PixieTheme
import fhs.mmt.nma.pixie.R

@Composable
fun PostCard(post: Post, profileName: String = "John Doe", location: String = "", onClick: () -> Unit = {}) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = colorResource(id = R.color.background))
    ){

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Box(modifier = Modifier
                .size(48.dp)
                .border(
                    width = 1.5.dp,
                    color = colorResource(id = R.color.primary),
                    shape = CircleShape
                )
            ){
                Image(
                    painter = painterResource(id = R.drawable.ivan),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                verticalArrangement = Arrangement.SpaceEvenly) {
                Text("$profileName ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.onBackground))
                if(location !== "") {
                    Text("$location",
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.onBackground))
                }
            }
        }
        Row(
            modifier = Modifier
                .height(LocalConfiguration.current.screenWidthDp.dp / 4F * 3F)
                .fillMaxWidth()
        ) {
            Image(
                painterResource(id = R.drawable.redpanda),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(24.dp)
                    .padding(all = 0.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = colorResource(id = R.color.onBackground)
                )
            ){
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = null
                    )
            }
            Text("42",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 8.dp),
                color = colorResource(id = R.color.onBackground)
            )

            Spacer(Modifier.weight(1f))

            TextButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(24.dp)
                    .padding(all = 0.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = colorResource(id = R.color.onBackground)
                )
            ){
                    Icon(
                        Icons.Filled.Comment,
                        contentDescription = null
                    )
                }

            Text("0",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 8.dp),
                color = colorResource(id = R.color.onBackground)
            )
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PostPreview(@PreviewParameter(PostSampleProvider::class) post: Post) {
    PixieTheme {
        PostCard(post = post, profileName="Harry Potter", location = "London")
    }
}




