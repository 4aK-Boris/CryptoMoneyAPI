package aleksandr.fedotkin

import aleksandr.fedotkin.core.di.appModule
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule

class ApplicationTest: KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(appModule)
    }

    @Test
    fun test() {
        println(5)
    }
}


