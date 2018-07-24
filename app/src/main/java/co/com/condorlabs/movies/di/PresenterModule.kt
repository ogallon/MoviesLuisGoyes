package co.com.condorlabs.movies.di

import co.com.condorlabs.movies.moviedetail.MovieDetailActivityPresenter
import co.com.condorlabs.movies.moviedetail.MovieDetailContract
import co.com.condorlabs.movies.movielist.MovieListActivityPresenter
import co.com.condorlabs.movies.movielist.MovieListContract
import co.com.condorlabs.movies.splash.SplashActivityPresenter
import co.com.condorlabs.movies.splash.SplashContract
import co.com.condorlabs.movies.utils.OBTAIN_MOVIE_DETAIL_INTERACTOR
import co.com.condorlabs.movies.utils.OBTAIN_POPULAR_MOVIES_INTERACTOR
import dagger.Module
import dagger.Provides
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
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
            @Named(OBTAIN_MOVIE_DETAIL_INTERACTOR)
            mObtainMovieDetailInteractor: IUseCase<MovieDetail, String>
    ): MovieDetailContract.Presenter =
            MovieDetailActivityPresenter(mObtainMovieDetailInteractor)

    @Provides
    @Singleton
    fun providesMovieListPresenter(
            @Named(OBTAIN_POPULAR_MOVIES_INTERACTOR)
            mObtainPopularMoviesInteractor: IUseCase<PopularMoviesResponse, Any?>
    ): MovieListContract.Presenter =
            MovieListActivityPresenter(mObtainPopularMoviesInteractor)

    @Provides
    @Singleton
    fun providesSplashPresenter(): SplashContract.Presenter =
            SplashActivityPresenter()
}
