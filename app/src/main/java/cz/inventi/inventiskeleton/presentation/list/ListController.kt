package cz.inventi.inventiskeleton.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import cz.inventi.inventiskeleton.R
import kotlinx.android.synthetic.main.controller_list.view.*

/**
 * Created by semanticer on 05.05.2017.
 */

class ListController : MvpController<ListView, ListPresenter>(), ListView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_list, container, false)
        return view
    }

    override fun createPresenter(): ListPresenter {
        return ListPresenter()
    }

    override fun showText(text: String) {
        view?.testText?.text = text
    }
}
