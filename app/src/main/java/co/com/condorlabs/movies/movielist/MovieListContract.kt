package co.com.condorlabs.movies.movielist

import android.os.Bundle
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
        fun initializeAdapter(movies: List<Movie>)
        fun navigateTo(destination: Class<*>, arguments: Bundle? = null)
    }

    interface Presenter : IBasePresenter<View> {
        fun loadData()
        fun recyclerViewItemClicked( position : Int )
    }
}
