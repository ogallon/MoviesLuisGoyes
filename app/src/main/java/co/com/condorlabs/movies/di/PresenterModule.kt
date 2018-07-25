package co.com.condorlabs.movies.di

import co.com.condorlabs.movies.moviedetail.MovieDetailActivityPresenter
import co.com.condorlabs.movies.moviedetail.MovieDetailContract
import co.com.condorlabs.movies.movielist.MovieListActivityPresenter
import co.com.condorlabs.movies.movielist.MovieListContract
import co.com.condorlabs.movies.splash.SplashActivityPresenter
import co.com.condorlabs.movies.splash.SplashContract
import co.com.condorlabs.movies.utils.GET_MOVIES_INTERACTOR
import co.com.condorlabs.movies.utils.GET_MOVIE_EXTRAS_INTERACTOR
import dagger.Module
import dagger.Provides
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */
@Module
class PresenterModule {
    @Provides
    @Singleton
    fun providesMovieDetailPresenter(
            @Named(GET_MOVIE_EXTRAS_INTERACTOR) getMovieExtrasInteractor : IUseCase<Movie, Movie>
    ): MovieDetailContract.Presenter =
            MovieDetailActivityPresenter(getMovieExtrasInteractor)

    @Provides
    @Singleton
    fun providesMovieListPresenter(
            @Named(GET_MOVIES_INTERACTOR) getMoviesInteractor: IUseCase<List<Movie>, Any?>
    ): MovieListContract.Presenter =
            MovieListActivityPresenter(getMoviesInteractor)

    @Provides
    @Singleton
    fun providesSplashPresenter(): SplashContract.Presenter =
            SplashActivityPresenter()
}
