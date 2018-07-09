package co.com.condorlabs.movies

/**
 * @author Oscar Gallon on 7/9/18.
 */
interface IBasePresenter<T : IBaseView> {

    var mView: T?

    fun bind(view: T) {
        mView = view
    }

    fun unbind() {
        mView = null
    }
}