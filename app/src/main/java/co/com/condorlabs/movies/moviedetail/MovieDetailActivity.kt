package co.com.condorlabs.movies.moviedetail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import co.com.condorlabs.movies.MoviesApplication
import co.com.condorlabs.movies.R
import io.condorlabs.lgoyes.domain.models.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*
import javax.inject.Inject

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieDetailActivity : AppCompatActivity(), MovieDetailContract.View {
    override fun drawView(movie: Movie) {
        tv_activitydetail_title?.text = movie.name
        tv_activitydetail_overview_content?.text = movie.overview
        tv_activitydetail_releasedate_content?.text = movie.releaseDate
        tv_activitydetail_budget_content?.text = movie.budget

        movie.trailerLink?.let {
            tv_activitydetail_watchtrailer?.visibility = View.VISIBLE
            tv_activitydetail_watchtrailer?.setOnClickListener {
                val youtubeIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("vnd.youtube:" + it
                        )
                )
                val youtubeWebIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://www.youtube.com/watch?v=" + it
                        )
                )
                try {
                    this.startActivity(youtubeIntent)
                } catch (ex: ActivityNotFoundException) {
                    this.startActivity(youtubeWebIntent)
                }
            }
        }
    }

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
