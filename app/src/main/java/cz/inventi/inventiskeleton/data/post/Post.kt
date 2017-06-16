package cz.inventi.inventiskeleton.data.post

/**
 * Created by tomas.valenta on 5/11/2017.
 */

data class Post(@JvmField var userId: Int = 0, @JvmField var id: Int = 0, @JvmField var title: String = "", @JvmField var body: String = "")