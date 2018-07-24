package co.com.condorlabs.movies.movielist

import co.com.condorlabs.movies.presenters.IBasePresenter
import co.com.condorlabs.movies.views.IBaseView
import io.condorlabs.lgoyes.domain.models.Movie

/**
 * @author Luis Goyes on 7/19/18.
 */
interface MovieListContract {
    interface View : IBaseView {
        fun startLoadingAnimation()
        fun stopLoadingAnimation()
        fun showMovies( movies : List<Movie> )
    }

    interface Presenter: IBasePresenter<View> {

    }
}
