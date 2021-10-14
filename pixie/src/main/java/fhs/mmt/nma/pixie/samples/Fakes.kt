package fhs.mmt.nma.pixie.samples

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import fhs.mmt.nma.pixie.data.Comment
import fhs.mmt.nma.pixie.data.Photographer
import fhs.mmt.nma.pixie.data.Photography
import fhs.mmt.nma.pixie.data.Post
import fhs.mmt.nma.pixie.data.User
import kotlin.random.Random

private val FakeUserNames = listOf(
    "Magda Reinlangen",
    "Wanda Lissmus",
    "Sergej Fährlich",
    "Brunhilde",
    "Wilhelm",
    "MemeK1ng",
    "user9981247",
    "Donald Duck",
    "Darth_Vader_1337",
    "Lazer_Saber_Boy",
    "Lancelot",
    "Alice Wonder"
)

val FakeUsers = FakeUserNames.mapIndexed { index, name -> generateFakeUser(index, name) }

val FakePosts = List(100) {
    generateFakePost()
}

internal fun generateFakePost(
    photos: Int = Random.nextInt(from = 1, until = 10),
    likes: Int = Random.nextInt(from = 0, until = 999_999),
    comments: Int = Random.nextInt(0, 1_000)
) = Post(
    author = FakeUsers.random().asFakePhotographer(),
    photos = List(photos) { if (Random.nextBoolean()) generatePexelsPhoto() else generateDuckPhoto() },
    likes = likes,
    comments = generateComments(comments)
)

private fun User.asFakePhotographer() = Photographer(
    id = id,
    name = name,
    picture = picture,
    bio = LoremIpsum(400).values.joinToString()
)

internal fun generateFakeUser(userId: Int = 0, name: String = FakeUserNames.random()) =
    Photographer(
        id = userId,
        name = name,
        picture = generateDuckPhoto().url,
        bio = LoremIpsum(Random.nextInt(0, 400)).values.joinToString()
    )

internal fun generateComment(maxWords: Int = 20, author: User = FakeUsers.random()) = Comment(
    message = LoremIpsum(Random.nextInt(1, maxWords)).values.joinToString(),
    author = author
)

internal fun generateComments(amount: Int = Random.nextInt(0, 20)) = List(amount) {
    generateComment()
}

internal fun generatePhoto(url: String) = Photography(
    url = url
)

internal fun generatePexelsPhoto(id: Int = Random.nextInt(from = 6_000_000, until = 8_999_999)) =
    generatePhoto(
        url = "https://images.pexels.com/photos/$id/pexels-photo-$id.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=1080"
    )

internal fun generateDuckPhoto(id: Int = Random.nextInt(from = 1, until = 192)) = generatePhoto(
    url = "https://random-d.uk/api/v2/$id.jpg"
)
