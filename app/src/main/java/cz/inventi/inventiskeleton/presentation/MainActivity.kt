package cz.inventi.inventiskeleton.presentation

import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.presentation.common.ActionBarProvider
import cz.inventi.inventiskeleton.presentation.post.list.PostListController
import dagger.android.support.DaggerAppCompatActivity

open class MainActivity : DaggerAppCompatActivity(), ActionBarProvider {

    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val controllerContainer = findViewById<ViewGroup>(R.id.controller_container)

        router = Conductor.attachRouter(this, controllerContainer, savedInstanceState)
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
