package co.com.condorlabs.movies.splash

import co.com.condorlabs.movies.utils.callbacks.IErrorHandler

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */
class SplashActivityPresenter : SplashContract.Presenter {
    override var mErrorHandler: IErrorHandler? = null
    override var mView: SplashContract.View? = null


}
