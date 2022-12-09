package fedotkin.aleksandr.data.mappers.set

import fedotkin.aleksandr.data.core.DTO
import fedotkin.aleksandr.data.core.Mapper
import fedotkin.aleksandr.data.dto.set.certificate.buyer.PANOnly
import fedotkin.aleksandr.domain.core.Model
import fedotkin.aleksandr.domain.models.set.PANOnlyModel

class PANOnlyMapper: Mapper {

    override fun <T : Model, R : DTO> map(value: T): R {
        val k = value a PANOnlyModel
    }

}