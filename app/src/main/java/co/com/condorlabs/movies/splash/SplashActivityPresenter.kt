package co.com.condorlabs.movies.splash

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import co.com.condorlabs.movies.utils.callbacks.IErrorHandler
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */
class SplashActivityPresenter : SplashContract.Presenter {
    override var mErrorHandler: IErrorHandler? = null
    override var mView: SplashContract.View? = null

    private val mSubscriptions: CompositeDisposable? = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clearSubscriptions() {
        mSubscriptions?.clear()
    }
}
