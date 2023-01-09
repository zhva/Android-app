package fhs.mmt.nma.pixie.samples.providers

import fhs.mmt.nma.pixie.data.Photography
import fhs.mmt.nma.pixie.data.ProfileInfo
import fhs.mmt.nma.pixie.samples.AllPosts
import fhs.mmt.nma.pixie.samples.AllUsers

class ProfileInfoProvider {
    companion object {
        fun getProfileInfo(userId: Int): ProfileInfo {
            var profileInfo = ProfileInfo()
            val user = AllUsers.find { it.id == userId }
            if (user != null) {
                profileInfo.name = user.name
                profileInfo.picture = user.picture
                profileInfo.bio = user.bio
                profileInfo.location = user.location
                profileInfo.instagram = user.instagram
            }

            val userPosts = AllPosts.filter { it.author.id == userId }
            var photos = ArrayList<Photography>()
            userPosts.forEach { post -> photos.addAll(post.photos) }
            photos = photos.distinct() as ArrayList<Photography>

            profileInfo.photos = photos

            var comments = 0
            userPosts.forEach { post -> comments += post.comments.size }

            profileInfo.comments = comments

            var likes = 0
            userPosts.forEach { post -> likes += post.likes }

            profileInfo.likes = likes

            return profileInfo
        }
    }
}