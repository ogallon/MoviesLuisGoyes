package io.condorlabs.lgoyes.data.di

import dagger.Provides
import io.condorlabs.lgoyes.data.network.endpoints.MoviesService
import io.condorlabs.lgoyes.data.utils.BASE_OK_HTTP_CLIENT
import io.condorlabs.lgoyes.data.utils.BASE_RETROFIT
import io.condorlabs.lgoyes.data.utils.BASE_URL
import io.condorlabs.lgoyes.data.utils.TIMEOUT_SECONDS
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
class ServiceProviderModule {

    @Named(BASE_OK_HTTP_CLIENT)
    @Provides
    @Singleton
    fun provideBaseClient():OkHttpClient {
        val builder = OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)

        return builder.build()
    }

    @Named(BASE_RETROFIT)
    @Provides
    @Singleton
    fun provideBaseRetrofit( @Named(BASE_OK_HTTP_CLIENT) baseOkHttpClient: OkHttpClient ): Retrofit {
        return Retrofit.Builder().baseUrl( BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(baseOkHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideMoviesService(@Named(BASE_RETROFIT) retrofit: Retrofit): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }
}
