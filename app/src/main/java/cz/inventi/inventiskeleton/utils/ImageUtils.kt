package cz.inventi.inventiskeleton.utils

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import cz.inventi.inventiskeleton.R

/**
 * Created by ecnill on 01-Jul-17.
 */

object ImageUtils {

    fun downloadImageIntoImageView(activity: Activity?, url: String, source: ImageView) {
        Glide.with(activity)
                .load(url)
                .apply(ImageUtils.imageOptions())
                .into(source)
    }

    fun downloadImageIntoImageView(context: Context, url: String, source: ImageView) {
        Glide.with(context)
                .load(url)
                .apply(ImageUtils.imageOptions())
                .into(source)
    }

    private fun imageOptions(): RequestOptions {
        return RequestOptions()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
    }

}
