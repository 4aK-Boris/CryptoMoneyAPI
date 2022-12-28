package aleksandr.fedotkin.set.protocol.domain.repositories.certificate.reg.form.req

import aleksandr.fedotkin.set.protocol.data.dto.certificate.reg.form.req.RegFormReq
import aleksandr.fedotkin.set.protocol.domain.models.certificate.reg.form.req.RegFormReqModel
import java.math.BigInteger
import kotlinx.serialization.KSerializer

interface RegFormReqRepository {

    val convertToModel: (RegFormReq) -> RegFormReqModel

    val convertToDTO: (RegFormReqModel) -> RegFormReq

    val serializer: KSerializer<RegFormReq>
    suspend fun createRegFormReqModel(
        number: String,
        lidEE: BigInteger,
        lidCA: BigInteger,
        rrpid: BigInteger,
        caeThumb: ByteArray
    ): RegFormReqModel
}
