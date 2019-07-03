package co.com.condorlabs.movies.moviedetail

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Bundle
import co.com.condorlabs.movies.utils.EXTRA_MOVIE_ID
import co.com.condorlabs.movies.utils.GET_FULL_MOVIE_INTERACTOR
import co.com.condorlabs.movies.utils.callbacks.IErrorHandler
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Named

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieDetailActivityPresenter(
        @Named(GET_FULL_MOVIE_INTERACTOR) private val getFullMovieInteractor: IUseCase<Movie, String>
) : MovieDetailContract.Presenter {


    override var movieId: String? = null
    override var mErrorHandler: IErrorHandler? = null
    override var mView: MovieDetailContract.View? = null

    private val mSubscriptions: CompositeDisposable? = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun loadData() {
        movieId?.let {movieID->
            mSubscriptions?.add(
                    getFullMovieInteractor.execute(
                            movieID,
                            {
                                mView?.drawView( it )
                            },
                            ::handleException
                    )
            )
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clearSubscriptions() {
        mSubscriptions?.clear()
    }

    override fun initialize(extras: Bundle?) {
        extras?.getString(EXTRA_MOVIE_ID, null)?.let { movieId ->
            this.movieId = movieId
        }
    }
}
