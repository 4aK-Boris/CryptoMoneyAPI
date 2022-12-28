package aleksandr.fedotkin.set.protocol.domain.repositories.certificate.reg.form.req

import aleksandr.fedotkin.set.protocol.data.dto.certificate.reg.form.req.RegFormReqData
import aleksandr.fedotkin.set.protocol.domain.models.certificate.reg.form.req.RegFormReqDataModel
import java.math.BigInteger
import kotlinx.serialization.KSerializer

interface RegFormReqDataRepository {

    val serializer: KSerializer<RegFormReqData>

    val convertToModel: (RegFormReqData) -> RegFormReqDataModel

    val convertToDTO: (RegFormReqDataModel) -> RegFormReqData

    suspend fun createRegFormReqDataModel(
        rrpid: BigInteger,
        lidEE: BigInteger,
        lidCA: BigInteger
    ): RegFormReqDataModel
}