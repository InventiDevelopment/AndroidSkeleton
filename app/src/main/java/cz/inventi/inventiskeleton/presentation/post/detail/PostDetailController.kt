package cz.inventi.inventiskeleton.presentation.post.detail

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.data.comment.Comment
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.di.conductorlib.ConductorInjection
import cz.inventi.inventiskeleton.presentation.common.BaseController
import cz.inventi.inventiskeleton.presentation.common.bindView
import cz.inventi.inventiskeleton.utils.ImageUtils
import de.hdodenhof.circleimageview.CircleImageView
import javax.inject.Inject

/**
 * Created by ecnill on 6/7/2017.
 */

class PostDetailController(bundle: Bundle) : BaseController<PostDetailView, PostDetailPresenter>(bundle), PostDetailView {

    companion object {
        val TAG: String = PostDetailController::class.java.name

        fun instance(id: Int) : PostDetailController {
            val args = Bundle()
            args.putInt(TAG, id)
            return PostDetailController(args)
        }
    }

    @Inject lateinit var postDetailPresenter : PostDetailPresenter
    val commentListAdapter = CommentListAdapter()

    internal val postTitle: TextView by bindView(R.id.txt_post_title)
    internal val postBody: TextView by bindView(R.id.txt_post_body)
    internal val userProfilePicture: CircleImageView by bindView(R.id.img_user_avatar)
    internal val btnShowComments: Button by bindView(R.id.btn_show_comments)
    internal val listComments: RecyclerView by bindView(R.id.list_comments)

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_post_detail, container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        ConductorInjection.inject(this)
        postDetailPresenter.postId = args.getInt(TAG)
        return super.onCreateView(inflater, container)
    }

    override fun onViewBind(view: View) {
        btnShowComments.setOnClickListener { presenter.onShowMoreCommentsClicked() }
        listComments.layoutManager = LinearLayoutManager(activity)
        listComments.adapter = commentListAdapter
    }

    override fun createPresenter() = postDetailPresenter

    override fun showDetailPost(post: Post) {
        postTitle.text = post.title
        postBody.text = post.body
        presenter.showUserProfilePicture(post.userId)
        showComments(post.comments)
    }

    override fun showProfilePicture(url: String) {
        ImageUtils.downloadImageIntoImageView(activity, url, userProfilePicture)
    }

    override fun showComments(comments: List<Comment>) {
        commentListAdapter.commentList = comments as MutableList<Comment>
    }

    override fun hideMoreCommentButton() {
        btnShowComments.visibility = View.GONE
    }

}
