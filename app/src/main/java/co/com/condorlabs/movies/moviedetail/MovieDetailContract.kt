package co.com.condorlabs.movies.moviedetail

import android.os.Bundle
import co.com.condorlabs.movies.presenters.IBasePresenter
import co.com.condorlabs.movies.views.IBaseView

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */
interface MovieDetailContract {
    interface View : IBaseView {

    }

    interface Presenter : IBasePresenter<View> {
        var movieId: String?

        fun initialize(extras: Bundle?)
    }
}
