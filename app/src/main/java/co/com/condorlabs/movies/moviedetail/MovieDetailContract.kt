package co.com.condorlabs.movies.moviedetail

import android.os.Bundle
import co.com.condorlabs.movies.presenters.IBasePresenter
import co.com.condorlabs.movies.views.IBaseView
import io.condorlabs.lgoyes.domain.models.Movie

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */
interface MovieDetailContract {
    interface View : IBaseView {
        fun drawView(movie: Movie)
    }

    interface Presenter : IBasePresenter<View> {
        var movieId: String?

        fun initialize(extras: Bundle?)
    }
}
