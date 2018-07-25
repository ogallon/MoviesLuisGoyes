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
        private val getMoviesInteractor: IUseCase<List<Movie>, Any?>
) : MovieListContract.Presenter {

    override var mErrorHandler: IErrorHandler? = null
    override var mView: MovieListContract.View? = null

    private val mSubscriptions: CompositeDisposable? = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        mView?.startLoadingAnimation()

        mSubscriptions?.add( getMoviesInteractor.execute(null,{
            updateAdapter( it )
        },::handleException))
    }

    fun updateAdapter( movies : List<Movie>) {
        movies.map {
            Log.d("Goyes", it.name)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clearSubscriptions() {
        mSubscriptions?.clear()
    }
}
