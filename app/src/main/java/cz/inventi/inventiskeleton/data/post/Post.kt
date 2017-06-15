package cz.inventi.inventiskeleton.data.post

import cz.inventi.inventiskeleton.data.comment.Comment

/**
 * Created by tomas.valenta on 5/11/2017.
 */

data class Post(val userId: Int, val id: Int, val title: String, val body: String, val comments: List<Comment> = listOf())
