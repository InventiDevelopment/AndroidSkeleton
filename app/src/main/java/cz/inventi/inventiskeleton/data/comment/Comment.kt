package cz.inventi.inventiskeleton.data.comment

/**
 * Created by ecnill on 14-Jun-17.
 */

data class Comment(
        var postId: Int,
        var id: Int,
        var name: String,
        var email: String,
        var body: String
)
