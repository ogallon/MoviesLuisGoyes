package co.com.condorlabs.movies.movielist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.com.condorlabs.movies.R

class MovieListActivity : AppCompatActivity(), MoviewListContract.View {

    private val mPresenter: MoviewListContract.Presenter = MoviewListActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        mPresenter.bind(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unbind()
    }

    override fun showMovies(movies: List<Any>) {

    }
}
