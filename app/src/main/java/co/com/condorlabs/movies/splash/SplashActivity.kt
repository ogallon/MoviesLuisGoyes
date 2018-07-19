package co.com.condorlabs.movies.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.com.condorlabs.movies.R

class SplashActivity : AppCompatActivity(), SplashContract.View {
    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(errorStringId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToWithErrorType(destination: Class<*>, errorType: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
