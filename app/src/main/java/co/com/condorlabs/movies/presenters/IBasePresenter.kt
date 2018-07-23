package co.com.condorlabs.movies.presenters

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import co.com.condorlabs.movies.views.IBaseView

/**
 * @author Oscar Gallon on 7/9/18.
 */
interface IBasePresenter<T : IBaseView> : LifecycleObserver {

    var mView: T?

    fun bind(view: T) {
        mView = view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unsubscribe() {
        mView = null
    }

}
