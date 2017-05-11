package cz.inventi.inventiskeleton.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup

import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

import butterknife.BindView
import butterknife.ButterKnife
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.presentation.post.list.PostListController

open class MainActivity : AppCompatActivity() {

    private lateinit var router: Router

    @JvmField @BindView(R.id.controller_container)
    internal var container: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        router = Conductor.attachRouter(this, container!!, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(PostListController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}
