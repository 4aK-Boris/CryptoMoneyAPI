package fedotkin.aleksandr.data.dto.set

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
class Identification {

    val number = ByteArray(SIZE)

    init {
        rnd.nextBytes(number)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Identification) return false
        return number.zip(other.number).fold(initial = true) { result, (first, second) ->
            result && (first == second)
        }
    }

    override fun hashCode() = number.fold(0) { result, value ->
        result + 31 * value
    }

    override fun toString() = number.joinToString(" ") { byte ->
        java.lang.String.format("%02X", byte)
    }

    companion object {

        private const val SIZE = 20

        private val rnd = Random
    }
}