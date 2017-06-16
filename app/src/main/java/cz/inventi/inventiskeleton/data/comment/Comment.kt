package cz.inventi.inventiskeleton.data.comment

/**
 * Created by ecnill on 14-Jun-17.
 */

data class Comment(@JvmField var postId: Int = 0, @JvmField var id: Int = 0, @JvmField var name: String = "", @JvmField var email: String = "", @JvmField var body: String = "")
