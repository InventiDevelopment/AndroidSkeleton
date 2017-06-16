package cz.inventi.inventiskeleton.presentation.post.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.data.comment.Comment
import cz.inventi.inventiskeleton.presentation.common.ViewBinder
import cz.inventi.inventiskeleton.presentation.common.bindView

/**
 * Created by ecnill on 15-Jun-17.
 */

class CommentListAdapter : RecyclerView.Adapter<CommentListAdapter.CommentViewHolder>() {

    val commentList = mutableListOf<Comment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = commentList[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    fun updateData(comments: List<Comment>) {
        commentList.clear()
        commentList.addAll(comments)
        notifyDataSetChanged()
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val txtCommentName: TextView by bindView(R.id.txt_comment_name)
        internal val txtCommentEmail: TextView by bindView(R.id.txt_comment_email)
        internal val txtCommentBody: TextView by bindView(R.id.txt_comment_body)

        init {
            ViewBinder.setup(this, itemView)
        }

        fun bind(comment: Comment) {
            txtCommentName.text = comment.name
            txtCommentEmail.text = comment.email
            txtCommentBody.text = comment.body
        }
    }

}
