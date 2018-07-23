package co.com.condorlabs.movies.moviedetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.com.condorlabs.movies.MoviesApplication
import co.com.condorlabs.movies.R
import javax.inject.Inject

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieDetailActivity : AppCompatActivity(), MovieDetailContract.View{
    @Inject
    lateinit var mPresenter: MovieDetailContract.Presenter

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
        setContentView(R.layout.activity_movie_detail)

        (application as MoviesApplication).getComponent().inject(this)
        lifecycle.addObserver(mPresenter)
        mPresenter.bind(this)
    }
}
