package co.com.condorlabs.movies.moviedetail

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import co.com.condorlabs.movies.presenters.IBasePresenter
import co.com.condorlabs.movies.views.IBaseView
import io.condorlabs.lgoyes.domain.models.Movie

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */
interface MovieDetailContract {
    interface View : IBaseView {

    }

    interface Presenter: IBasePresenter<View> {
        var movie: Movie?

        fun bind(view: View, movie : Movie) {
            super.bind(view)
            this.movie = movie
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        override fun unsubscribe() {
            movie = null
            super.unsubscribe()
        }
    }
}
