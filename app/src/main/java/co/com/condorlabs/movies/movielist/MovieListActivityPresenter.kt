package co.com.condorlabs.movies.movielist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import co.com.condorlabs.movies.utils.callbacks.IErrorHandler
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieListActivityPresenter(
        val mObtainPopularMoviesInteractor: IUseCase<List<Movie>, Any?>,
        val mInsertMovieEntryInteractor: IUseCase<Long, Movie>,
        val mGetAllMovieEntriesInteractor: IUseCase<List<Movie>, Any?>,
        val mDeleteMovieEntryInteractor: IUseCase<Int, Movie>
) : MovieListContract.Presenter {

    override var mErrorHandler: IErrorHandler? = null
    override var mView: MovieListContract.View? = null

    private val mSubscriptions: CompositeDisposable? = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        mView?.startLoadingAnimation()

        clearAllMovieEntries()

        downloadStoreAndShowPopularMovies()
    }

    fun downloadStoreAndShowPopularMovies() {
        mSubscriptions?.add(mObtainPopularMoviesInteractor.execute(null,
                {
                    it.forEach {
                        storeMovieEntry( it )
                    }

                    mView?.showMovies(it)

                }, ::handleException))
    }

    fun storeMovieEntry(movieEntry: Movie) {
        mSubscriptions?.add(
                mInsertMovieEntryInteractor.execute(
                        movieEntry,
                        {},
                        {
                            throw it
                        }
                )
        )
    }

    fun clearAllMovieEntries() {
        mSubscriptions?.add(
                mGetAllMovieEntriesInteractor.execute(
                        null,
                        {
                            it.map {
                                deleteMovieEntry(it)
                            }
                        },
                        ::handleException
                )
        )
    }

    @Throws
    fun deleteMovieEntry(movieEntry: Movie) {
        mSubscriptions?.add(
                mDeleteMovieEntryInteractor.execute(
                        movieEntry,
                        {},
                        {
                            throw it
                        }
                )
        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clearSubscriptions() {
        mSubscriptions?.clear()
    }
}
