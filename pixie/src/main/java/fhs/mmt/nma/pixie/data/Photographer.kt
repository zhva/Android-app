package fhs.mmt.nma.pixie.data

data class Photographer(
    override val id: Int,
    override val name: String,
    override val picture: String,
    val bio: String,
    val profile: String? = null,
    val location: String? = null,
    val instagram: String? = null,
) : User

