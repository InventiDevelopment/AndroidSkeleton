package cz.inventi.inventiskeleton.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.hannesdorfmann.mosby3.mvp.conductor.MvpController

import butterknife.BindView
import butterknife.ButterKnife
import cz.inventi.inventiskeleton.R

/**
 * Created by semanticer on 05.05.2017.
 */

class ListController : MvpController<ListView, ListPresenter>(), ListView {

    @JvmField @BindView(R.id.test_text)
    internal var testText: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_list, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun createPresenter(): ListPresenter {
        return ListPresenter()
    }

    override fun showText(text: String) {
        testText!!.text = text
    }
}
