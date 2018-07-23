package co.com.condorlabs.movies.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.com.condorlabs.movies.MoviesApplication
import co.com.condorlabs.movies.R
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashContract.View {

    @Inject
    lateinit var mPresenter: SplashContract.Presenter

    override fun navigateTo(destination: Class<*>, arguments: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        Toast.makeText( applicationContext, error, Toast.LENGTH_LONG ).show()
    }

    override fun showError(errorStringId: Int) {
        Toast.makeText( applicationContext, getString( errorStringId ), Toast.LENGTH_LONG ).show()
    }

    override fun navigateToWithErrorType(destination: Class<*>, errorType: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        (application as MoviesApplication).getComponent().inject(this)
        lifecycle.addObserver( mPresenter )
        mPresenter.bind( this )
    }
}
