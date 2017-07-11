package cz.inventi.inventiskeleton.utils

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView

/**
 * Created by ecnill on 03-Jul-17.
 */

interface AutoUpdatableAdapter {
    fun <T> RecyclerView.Adapter<*>.autoNotify(oldList: MutableList<T>, newList: MutableList<T>, compare: (T, T) -> Boolean) {
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return compare(oldList[oldItemPosition], newList[newItemPosition])
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition] == newList[newItemPosition]
            }

            override fun getOldListSize() = oldList.size

            override fun getNewListSize() = newList.size
        })

        diff.dispatchUpdatesTo(this)
    }

}