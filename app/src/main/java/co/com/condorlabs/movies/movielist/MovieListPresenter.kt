package co.com.condorlabs.movies.movielist

/**
 * @author Luis Goyes on 7/19/18.
 */
class MovieListPresenter : MovieListContract.Presenter {

    override var mView: MovieListContract.View? = null

    private fun onResume() {
        //valla por la peliculas
        mView?.showMovies(arrayListOf())
    }

}