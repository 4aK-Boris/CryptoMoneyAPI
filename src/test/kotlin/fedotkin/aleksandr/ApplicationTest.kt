package fedotkin.aleksandr

import fedotkin.aleksandr.presentation.routing.configureRouting
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import java.math.BigInteger
import junit.framework.TestCase.assertEquals
import org.junit.Test
import kotlin.random.Random

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    val rnd = Random

    @Test
    fun test() {
        val k = BigInteger(rnd.nextBytes(20))
        println(k)
        println(k.toString())
        println(k.toString().toBigInteger())

    }
}
