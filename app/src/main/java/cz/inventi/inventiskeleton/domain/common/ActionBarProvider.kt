package cz.inventi.inventiskeleton.domain.common

import android.support.v7.app.ActionBar

/**
 * Created by tomas.valenta on 5/11/2017.
 */
interface ActionBarProvider {
    fun getSupportActionBar(): ActionBar?
}