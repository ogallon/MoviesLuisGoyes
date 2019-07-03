/*
 * Copyright (c) Evercheck 2018.
 */

package co.com.condorlabs.movies.utils.callbacks

/**
 * @author Oscar Gallon on 7/5/18.
 */
interface IErrorHandler {

    fun showError(error: String)

    fun showError(errorStringId: Int)

    fun navigateToWithErrorType(destination: Class<*>, errorType: Int)
}
