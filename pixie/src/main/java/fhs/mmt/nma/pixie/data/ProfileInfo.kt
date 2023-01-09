package fhs.mmt.nma.pixie.data

data class ProfileInfo(
    var name: String = "",
    var picture: String = "",
    var bio: String = "",
    var location: String? = null,
    var instagram: String? = null,
    var photos: ArrayList<Photography> = ArrayList<Photography>(),
    var comments: Int = 0,
    var likes: Int = 0
) {

}