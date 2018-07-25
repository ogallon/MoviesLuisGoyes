package co.com.condorlabs.movies.movielist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Bundle
import android.util.Log
import co.com.condorlabs.movies.moviedetail.MovieDetailActivity
import co.com.condorlabs.movies.utils.EXTRA_MOVIE_ID
import co.com.condorlabs.movies.utils.callbacks.IErrorHandler
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieListActivityPresenter(
        private val getMoviesInteractor: IUseCase<List<Movie>, Any?>
) : MovieListContract.Presenter {
    override fun recyclerViewItemClicked(position: Int) {
        mView?.navigateTo(MovieDetailActivity::class.java,
                Bundle().apply {
                    movies?.get(position)?.let {
                        putString(EXTRA_MOVIE_ID, it.movieId)
                    }
                })
    }

    override var mErrorHandler: IErrorHandler? = null
    override var mView: MovieListContract.View? = null

    private val mSubscriptions: CompositeDisposable? = CompositeDisposable()

    var movies: List<Movie>? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun loadData() {
        mView?.startLoadingAnimation()

        mSubscriptions?.add(getMoviesInteractor.execute(
                null,
                {
                    movies = it
                    mView?.initializeAdapter(it)
                },
                ::handleException,
                {
                    mView?.stopLoadingAnimation()
                }
        ))
    }

    fun initializeAdapter(movies: List<Movie>) {
        movies.map {
            Log.d("Goyes", it.name)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clearSubscriptions() {
        mSubscriptions?.clear()
    }
}
