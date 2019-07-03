package co.com.condorlabs.movies.di

import dagger.Module
import dagger.Provides
import io.condorlabs.lgoyes.domain.IO_THREAD_SCHEDULER
import io.condorlabs.lgoyes.domain.MAIN_THREAD_SCHEDULER
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
@Module
class SchedulerModule {

    @Provides
    @Named(IO_THREAD_SCHEDULER)
    fun provideIOScheduler(): Scheduler = Schedulers.io()

    @Provides
    @Named(MAIN_THREAD_SCHEDULER)
    fun provideMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()
}
