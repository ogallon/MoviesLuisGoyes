package co.com.condorlabs.movies.movielist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import co.com.condorlabs.movies.utils.callbacks.IErrorHandler
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.models.MovieEntry
import io.condorlabs.lgoyes.domain.models.PopularMoviesResponse
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieListActivityPresenter(
        val mObtainPopularMoviesInteractor: IUseCase<PopularMoviesResponse, Any?>,
        val mInsertMovieEntryInteractor: IUseCase<Long, MovieEntry>,
        val mGetAllMovieEntriesInteractor: IUseCase<List<MovieEntry>, Any?>,
        val mDeleteMovieEntryInteractor: IUseCase<Int, MovieEntry>
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
                    it.results.forEach {
                        val newMovieEntry = MovieEntry(null,
                                it.id.toString(),
                                it.title,
                                it.voteCount.toString(),
                                it.posterPath,
                                it.voteAverage.toString(),
                                it.overview,
                                it.releaseDate,
                                null,
                                null,
                                false)

                        storeMovieEntry(newMovieEntry)
                    }

                    mView?.showMovies(it.results)

                }, ::handleException))
    }

    fun storeMovieEntry(movieEntry: MovieEntry) {
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
    fun deleteMovieEntry(movieEntry: MovieEntry) {
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
