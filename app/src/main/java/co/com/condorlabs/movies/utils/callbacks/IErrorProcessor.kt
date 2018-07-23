package co.com.condorlabs.movies.utils.callbacks

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
        }
    }
}
