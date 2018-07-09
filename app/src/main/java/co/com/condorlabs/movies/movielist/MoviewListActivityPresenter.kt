package co.com.condorlabs.movies.movielist

/**
 * @author Oscar Gallon on 7/9/18.
 */
class MoviewListActivityPresenter : MoviewListContract.Presenter {

    override var mView: MoviewListContract.View? = null

    private fun onResume() {
        //valla por la peliculas
        mView?.showMovies(arrayListOf())
    }

}