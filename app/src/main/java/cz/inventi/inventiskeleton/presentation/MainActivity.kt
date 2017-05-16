package cz.inventi.inventiskeleton.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.domain.common.ActionBarProvider
import cz.inventi.inventiskeleton.presentation.post.list.PostListController
import dagger.android.AndroidInjection

open class MainActivity : AppCompatActivity(), ActionBarProvider {

    private lateinit var router: Router

    private lateinit var controllerContainer: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        setContentView(R.layout.activity_main)
        controllerContainer = findViewById(R.id.controller_container) as ViewGroup

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
