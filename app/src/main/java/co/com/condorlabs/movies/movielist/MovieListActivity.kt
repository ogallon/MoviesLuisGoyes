package co.com.condorlabs.movies.movielist

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import co.com.condorlabs.movies.MoviesApplication
import co.com.condorlabs.movies.R
import io.condorlabs.lgoyes.domain.models.Movie
import kotlinx.android.synthetic.main.activity_movie_list.*
import javax.inject.Inject

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieListActivity : AppCompatActivity(), MovieListContract.View, MovieItemAdapter.IAdapterItemClick {
    override fun navigateTo(destination: Class<*>, arguments: Bundle?) {
        startActivity( Intent(this, destination).apply {
            arguments?.let {
                putExtras(it)
            }
        } )
        finish()
    }

    override fun onItemClicked( position:Int) {
        mPresenter.recyclerViewItemClicked( position )
    }

    @Inject
    lateinit var mPresenter: MovieListContract.Presenter

    override fun initializeAdapter(movies: List<Movie>) {
        rv_activitylist_list_movies?.adapter = MovieItemAdapter( this, movies)
    }

    override fun startLoadingAnimation() {
        gif_activitylist_saitamaloading?.visibility = View.VISIBLE
        gif_activitylist_saitamaloading?.play()
    }

    override fun stopLoadingAnimation() {
        gif_activitylist_saitamaloading?.visibility = View.GONE
        gif_activitylist_saitamaloading?.pause()
    }

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
        setContentView(R.layout.activity_movie_list)

        (application as MoviesApplication).getComponent().inject(this)
        lifecycle.addObserver(mPresenter)
        mPresenter.bind(this)

        rv_activitylist_list_movies?.layoutManager =
                LinearLayoutManager(
                        this,
                        LinearLayoutManager.VERTICAL,
                        false
                )
    }


}
