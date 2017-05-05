package cz.inventi.inventiskeleton.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import cz.inventi.inventiskeleton.R
import cz.inventi.inventiskeleton.presentation.list.ListController
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    private var router: Router? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, controllerContainer, savedInstanceState)
        if (!router!!.hasRootController()) {
            router!!.setRoot(RouterTransaction.with(ListController()))
        }
    }

    override fun onBackPressed() {
        if (!router!!.handleBack()) {
            super.onBackPressed()
        }
    }
}
