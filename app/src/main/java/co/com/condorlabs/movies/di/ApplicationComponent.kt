package co.com.condorlabs.movies.di

import co.com.condorlabs.movies.moviedetail.MovieDetailActivity
import co.com.condorlabs.movies.movielist.MovieListActivity
import co.com.condorlabs.movies.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */
@Singleton
@Component(modules = [ApplicationModule::class, PresenterModule::class])
interface ApplicationComponent {
    fun inject( target : SplashActivity )

    fun inject( target : MovieDetailActivity )

    fun inject( target : MovieListActivity )
}
