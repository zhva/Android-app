package fhs.mmt.nma.pixie.data

data class Post(
    val photos: List<Photography>,
    val author: Photographer,
    val likes: Int,
    val comments: List<Comment>
)

