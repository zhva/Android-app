package fhs.mmt.nma.pixie.ui.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import fhs.mmt.nma.pixie.R
import fhs.mmt.nma.pixie.data.Post
import fhs.mmt.nma.pixie.samples.providers.PostSampleProvider
import fhs.mmt.nma.pixie.ui.theme.PixieTheme

@Composable
fun PostCard(post: Post, onClick: () -> Unit = {}) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(){
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
            ) {
                Box(modifier = Modifier
                    .size(48.dp)
                    .border(
                        width = 1.5.dp,
                        shape = CircleShape,
                        color = MaterialTheme.colors.primary
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
                    Text(post.author.name.toString(),
                        style = MaterialTheme.typography.h2
                        )
                    if(post.author.location !== null) {
                        Text(post.author.location.toString(),
                        style = MaterialTheme.typography.body2)
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
                        contentColor = MaterialTheme.colors.onSurface
                    )
                ){
                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorite"
                        )
                }
                Text(post.likes.toString(),
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )

                Spacer(Modifier.weight(1f))

                TextButton(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(24.dp)
                        .padding(all = 0.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colors.onSurface
                    )
                ){
                        Icon(
                            Icons.Filled.Comment,
                            contentDescription = "Comment"
                        )
                    }

                Text(post.comments.size.toString(),
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp)) {
                val comments = post.comments.takeLast(2)
                comments.forEach {
                    ShowComment(author = it.author.name, message = it.message)
                }
                if(post.comments.size > 2) {
                    TextButton(onClick = { /*TODO*/ }) { // is it really a Button or a TextButton
                        Text(text = "Show all ${post.comments.size} Comments")

                    }
                }
            }
        }
    }
}
@Composable
fun ShowComment(author: String, message: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(author,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(bottom = 8.dp))
        Text(message,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(bottom = 8.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis)
    }
}
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PostPreview(@PreviewParameter(PostSampleProvider::class) post: Post) {
    PixieTheme {
        PostCard(post = post)
    }
}




