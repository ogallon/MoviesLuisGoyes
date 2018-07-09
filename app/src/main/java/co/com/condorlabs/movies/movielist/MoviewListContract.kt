package co.com.condorlabs.movies.movielist

import co.com.condorlabs.movies.IBasePresenter
import co.com.condorlabs.movies.IBaseView

/**
 * @author Oscar Gallon on 7/9/18.
 */
interface MoviewListContract {

    interface View : IBaseView {

        fun showMovies(movies: List<Any>)
    }

    interface Presenter: IBasePresenter<View> {

    }

}