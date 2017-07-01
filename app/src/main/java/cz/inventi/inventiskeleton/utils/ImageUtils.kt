package cz.inventi.inventiskeleton.utils

import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import cz.inventi.inventiskeleton.R

/**
 * Created by ecnill on 01-Jul-17.
 */

object ImageUtils {

    fun imageOption(): RequestOptions {
        return RequestOptions()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .error(R.mipmap.ic_launcher_round)
                .priority(Priority.HIGH)
    }

}
