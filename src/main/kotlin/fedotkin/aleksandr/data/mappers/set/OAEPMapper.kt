package fedotkin.aleksandr.data.mappers.set

import fedotkin.aleksandr.data.core.Mapper
import fedotkin.aleksandr.data.dto.set.OAEP
import fedotkin.aleksandr.domain.models.set.OAEPModel
import io.ktor.util.encodeBase64

class OAEPMapper {

    fun <T, R> map(oaep: OAEP<T>, map()): OAEPModel<R> {
        return OAEPModel(
            k = oaep.k.encoded.encodeBase64(),
            hash = oaep.hash.encodeBase64(),
            p = mapper.map(value = oaep.p)
        )
    }
}