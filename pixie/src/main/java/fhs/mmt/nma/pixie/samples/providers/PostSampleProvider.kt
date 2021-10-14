package fhs.mmt.nma.pixie.samples.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import fhs.mmt.nma.pixie.data.Post
import fhs.mmt.nma.pixie.samples.IvanPosts

class PostSampleProvider : PreviewParameterProvider<Post> {
    override val values: Sequence<Post>
        get() = IvanPosts.asSequence()


}