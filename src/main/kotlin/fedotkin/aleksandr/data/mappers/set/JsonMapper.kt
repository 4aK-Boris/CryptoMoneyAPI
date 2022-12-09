package fedotkin.aleksandr.data.mappers.set

import io.ktor.util.decodeBase64Bytes
import io.ktor.util.encodeBase64
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class JsonMapper {

    fun <T> objectToByteArray(serializer: KSerializer<T>, data: T): ByteArray {
        return objectToString(serializer = serializer, data = data).decodeBase64Bytes()
    }

    fun <T> objectToString(serializer: KSerializer<T>, data: T): String {
        return Json.encodeToString(value = data, serializer = serializer)
    }

    fun <T> byteArrayToObject(deserializer: KSerializer<T>, data: ByteArray): T {
        return Json.decodeFromString(string = data.encodeBase64(), deserializer = deserializer)
    }

    fun <T> stringToObject(deserializer: KSerializer<T>, data: String): T {
        return Json.decodeFromString(string = data, deserializer = deserializer)
    }
}