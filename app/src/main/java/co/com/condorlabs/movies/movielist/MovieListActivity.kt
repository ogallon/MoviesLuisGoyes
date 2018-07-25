package co.com.condorlabs.movies.movielist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatImageView
import android.view.View
import android.widget.Toast
import co.com.condorlabs.movies.MoviesApplication
import co.com.condorlabs.movies.R
import co.com.condorlabs.movies.utils.loadImageFromURL
import io.condorlabs.lgoyes.domain.models.Movie
import kotlinx.android.synthetic.main.activity_movie_list.*
import javax.inject.Inject

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieListActivity : AppCompatActivity(), MovieListContract.View {
    override fun initializeAdapter(movies: List<Movie>) {
        TODO("Waiting for adapter definition")
//        rv_activitylist_list_movies?.adapter =
    }

    override fun startLoadingAnimation() {
        gif_activitylist_saitamaloading?.visibility = View.VISIBLE
        gif_activitylist_saitamaloading?.play()
    }

    override fun stopLoadingAnimation() {
        gif_activitylist_saitamaloading?.visibility = View.GONE
        gif_activitylist_saitamaloading?.pause()
    }

    @Inject
    lateinit var mPresenter: MovieListContract.Presenter

    override fun showError(error: String) {
        Toast.makeText( applicationContext, error, Toast.LENGTH_LONG ).show()
    }

    override fun showError(errorStringId: Int) {
        Toast.makeText( applicationContext, getString( errorStringId ), Toast.LENGTH_LONG ).show()
    }

    override fun navigateToWithErrorType(destination: Class<*>, errorType: Int) {
        startActivity(Intent(this, destination))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        (application as MoviesApplication).getComponent().inject(this)
        lifecycle.addObserver(mPresenter)
        mPresenter.bind(this)
    }
}
