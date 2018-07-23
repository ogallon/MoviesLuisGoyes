package co.com.condorlabs.movies

import android.app.Application
import co.com.condorlabs.movies.di.ApplicationComponent
import co.com.condorlabs.movies.di.ApplicationModule
import co.com.condorlabs.movies.di.DaggerApplicationComponent

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */
class MoviesApplication : Application() {
    private lateinit var component : ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .applicationModule( ApplicationModule(this) )
                .build()
    }

    fun getComponent() : ApplicationComponent = component
}
