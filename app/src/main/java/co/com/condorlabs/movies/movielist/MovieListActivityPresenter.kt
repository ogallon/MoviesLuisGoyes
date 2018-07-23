package co.com.condorlabs.movies.movielist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import co.com.condorlabs.movies.utils.callbacks.IErrorHandler
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieListActivityPresenter(
        val mObtainPopularMoviesInteractor: IUseCase<List<Movie>, Any?>
) : MovieListContract.Presenter {

    override var mErrorHandler: IErrorHandler? = null
    override var mView: MovieListContract.View? = null

    private val mSubscriptions: CompositeDisposable? = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun downloadMovies() {
        mSubscriptions?.add(mObtainPopularMoviesInteractor.execute(null,
                {
                    it.forEach {
                        Log.d("GOYES", "Descargue la pelicula ${it.title}")
                    }
                },
                {
                    ::handleException
                }
        ))
    }
}
