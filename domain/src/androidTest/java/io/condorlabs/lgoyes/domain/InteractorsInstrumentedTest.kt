package io.condorlabs.lgoyes.domain

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class InteractorsInstrumentedTest {
    lateinit var appContext: Context

    @Before
    fun init() {
        appContext = InstrumentationRegistry.getTargetContext()

    }
}
