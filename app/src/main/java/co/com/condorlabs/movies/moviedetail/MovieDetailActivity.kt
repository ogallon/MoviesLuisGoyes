package co.com.condorlabs.movies.moviedetail

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import co.com.condorlabs.movies.MoviesApplication
import co.com.condorlabs.movies.R
import javax.inject.Inject

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieDetailActivity : AppCompatActivity(), MovieDetailContract.View {
    @Inject
    lateinit var mPresenter: MovieDetailContract.Presenter

    override fun showError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    override fun showError(errorStringId: Int) {
        Toast.makeText(applicationContext, getString(errorStringId), Toast.LENGTH_LONG).show()
    }

    override fun navigateToWithErrorType(destination: Class<*>, errorType: Int) {
        startActivity(Intent(this, destination))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        (application as MoviesApplication).getComponent().inject(this)
        lifecycle.addObserver(mPresenter)
        mPresenter.bind(this)
        mPresenter.initialize(intent.extras)
    }
}
