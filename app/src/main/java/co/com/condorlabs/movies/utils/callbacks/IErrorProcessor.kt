package co.com.condorlabs.movies.utils.callbacks

import android.util.Log
import co.com.condorlabs.movies.R
import retrofit2.HttpException


/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
interface IErrorProcessor {

    var mErrorHandler: IErrorHandler?

    fun handleException(error: Throwable) {
        when (error) {
            is HttpException -> mErrorHandler?.showError( R.string.connection_error )
            is IllegalStateException -> Log.e(IErrorProcessor::class.java.name, error.message)
        }
    }
}
