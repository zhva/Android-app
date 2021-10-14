package fhs.mmt.nma.pixie.samples

import fhs.mmt.nma.pixie.data.Photographer
import fhs.mmt.nma.pixie.data.Post

val IvanCujic = Photographer(
    id = 20495,
    name = "Ivan Cujic",
    profile = "https://www.pexels.com/@ivan-cujic-20495",
    location = "Croatia",
    bio = "Buy me a coffee or follow me on instagram page. Your contribution will inspire me for more beautiful content.Thanks",
    instagram = "wildfoton",
    picture = "https://images.pexels.com/users/avatars/20495/ivan-cujic-349.jpeg",
)

val RedPanda = generatePexelsPhoto(2265247)
val DragonFly = generatePexelsPhoto(7989075)
val Pelican = generatePexelsPhoto(2265260)
val Lion1 = generatePexelsPhoto(2265258)
val Lion2 = generatePexelsPhoto(2265248)

val IvanPost1 = Post(
    photos = listOf(DragonFly),
    author = IvanCujic,
    comments = emptyList(),
    likes = 42
)

val IvanPost2 = Post(
    photos = listOf(RedPanda),
    author = IvanCujic,
    comments = generateComments(15),
    likes = 1337
)

val IvanPost3 = Post(
    photos = listOf(Pelican),
    author = IvanCujic,
    comments = generateComments(2),
    likes = 9_888_777
)

val IvanPost4 = Post(
    photos = listOf(Lion1, Lion2),
    author = IvanCujic,
    comments = generateComments(99),
    likes = 15_555
)

val IvanPosts = listOf(IvanPost1, IvanPost2, IvanPost3, IvanPost4)