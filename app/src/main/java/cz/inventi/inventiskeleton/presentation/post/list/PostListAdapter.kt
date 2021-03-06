package cz.inventi.inventiskeleton.presentation.post.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cz.inventi.inventiskeleton.BuildConfig.API_PROFILE_PIC
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.presentation.common.ViewBinder
import cz.inventi.inventiskeleton.presentation.common.bindView
import cz.inventi.inventiskeleton.utils.AutoUpdatableAdapter
import cz.inventi.inventiskeleton.utils.ImageUtils
import de.hdodenhof.circleimageview.CircleImageView
import kotlin.properties.Delegates

/**
 * Created by tomas.valenta on 5/16/2017.
 */

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.PostViewHolder>(), AutoUpdatableAdapter {

    var postList: MutableList<Post> by Delegates.observable(mutableListOf()) {
        _, old, new ->
        autoNotify(old, new) { o, n -> o.id == n.id }
    }

    var onPostSelectedListener: ((Post) -> Unit) = {}
        get
        set(value) {
            field = value
        }

    var onPostLongSelectedListener: ((Post) -> Boolean) = {false}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.bind(post)
        holder.itemView.setOnClickListener { onPostSelectedListener(post) }
        holder.itemView.setOnLongClickListener {onPostLongSelectedListener(post) }
    }

    override fun getItemCount() = postList.size


    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal val titleText: TextView by bindView(R.id.title)
        internal val imageView: CircleImageView by bindView(R.id.img_user_avatar)

        init {
            ViewBinder.setup(this, itemView)
        }

        fun bind(post: Post) {
            titleText.text = post.title
            ImageUtils.downloadImageIntoImageView(imageView.context,
                    API_PROFILE_PIC + post.userId.toString(),
                    imageView)
        }
    }

}
