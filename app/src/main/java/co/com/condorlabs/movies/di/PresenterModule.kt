package co.com.condorlabs.movies.di

import co.com.condorlabs.movies.moviedetail.MovieDetailActivityPresenter
import co.com.condorlabs.movies.moviedetail.MovieDetailContract
import co.com.condorlabs.movies.movielist.MovieListActivityPresenter
import co.com.condorlabs.movies.movielist.MovieListContract
import co.com.condorlabs.movies.splash.SplashActivityPresenter
import co.com.condorlabs.movies.splash.SplashContract
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */
@Module
class PresenterModule {
    @Provides
    @Singleton
    fun providesMovieDetailPresenter() : MovieDetailContract.Presenter =
            MovieDetailActivityPresenter()

    @Provides
    @Singleton
    fun providesMovieListPresenter() : MovieListContract.Presenter =
            MovieListActivityPresenter()

    @Provides
    @Singleton
    fun providesSplashPresenter() : SplashContract.Presenter =
        SplashActivityPresenter()
}
