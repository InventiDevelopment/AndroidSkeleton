package cz.inventi.inventiskeleton.presentation

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast

import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.domain.common.ActionBarProvider
import cz.inventi.inventiskeleton.presentation.post.list.PostListController
import dagger.android.AndroidInjection
import javax.inject.Inject

open class MainActivity : AppCompatActivity(), ActionBarProvider {

    private lateinit var router: Router

    @JvmField @BindView(R.id.controller_container)
    internal var container: ViewGroup? = null

    @Inject
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        setContentView(R.layout.activity_main)

        if (sp.getBoolean("neco", true)) {
            Toast.makeText(this, "TADAAAAA", Toast.LENGTH_LONG).show()
        }

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
