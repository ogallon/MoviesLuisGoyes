package co.com.condorlabs.movies.moviedetail

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import co.com.condorlabs.movies.utils.GET_MOVIE_EXTRAS_INTERACTOR
import co.com.condorlabs.movies.utils.callbacks.IErrorHandler
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Named

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieDetailActivityPresenter(
        @Named(GET_MOVIE_EXTRAS_INTERACTOR) getMovieExtrasInteractor: IUseCase<Movie, Movie>
) : MovieDetailContract.Presenter {
    override var movie: Movie? = null
    override var mErrorHandler: IErrorHandler? = null
    override var mView: MovieDetailContract.View? = null

    private val mSubscriptions: CompositeDisposable? = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun downloadMovieDetail() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clearSubscriptions() {
        mSubscriptions?.clear()
    }
}
