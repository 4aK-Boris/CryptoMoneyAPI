package aleksandr.fedotkin.set.protocol.data.mappers.certificate.cert.req

import aleksandr.fedotkin.set.protocol.core.mapper.SetMapper
import aleksandr.fedotkin.set.protocol.data.dto.certificate.cert.req.RegFormItems
import aleksandr.fedotkin.set.protocol.domain.models.certificate.cert.req.RegFormItemsModel
import kotlinx.serialization.KSerializer

class RegFormItemsMapper : SetMapper<RegFormItemsModel, RegFormItems> {

    override val serializer: KSerializer<RegFormItems>
        get() = RegFormItems.serializer()

    override fun map(value: RegFormItemsModel): RegFormItems {
        return RegFormItems(fieldName = value.fieldName, fieldValue = value.fieldValue)
    }

    override fun reverseMap(value: RegFormItems): RegFormItemsModel {
        return RegFormItemsModel(fieldName = value.fieldName, fieldValue = value.fieldValue)
    }
}
