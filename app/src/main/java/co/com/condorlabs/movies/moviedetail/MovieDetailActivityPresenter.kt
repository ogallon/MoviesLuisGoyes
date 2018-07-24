package co.com.condorlabs.movies.moviedetail

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import co.com.condorlabs.movies.utils.callbacks.IErrorHandler
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.MovieDetail
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieDetailActivityPresenter(
        var mObtainMovieDetailInteractor: IUseCase<MovieDetail, String>
) : MovieDetailContract.Presenter {
    override var mErrorHandler: IErrorHandler? = null
    override var mView: MovieDetailContract.View? = null

    private val mSubscriptions: CompositeDisposable? = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun downloadMovies() {
//        mSubscriptions?.add(mObtainMovieDetailInteractor.execute("351286",
//                {
//                    Log.d("GOYES", "Detalles de la pelicula ${it.title}")
//                },
//                {
//                    ::handleException
//                }
//        ))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clearSubscriptions() {
        mSubscriptions?.clear()
    }
}
