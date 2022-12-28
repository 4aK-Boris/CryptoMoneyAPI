package aleksandr.fedotkin.set.protocol.domain.useceses

import aleksandr.fedotkin.set.protocol.domain.repositories.certificate.cert.req.CertReqRepository

class CertReqUseCase(
    private val certReqRepository: CertReqRepository
) {//: RequestUseCase<CertReqModel, CertReq>() {

//    override val serializer = certReqRepository.serializer
//
//    override val convertToDTO = certReqRepository.convertToDTO
//
//    override val convertToModel = certReqRepository.convertToModel
//
//    suspend fun createAndSendMessageWrapper(
//        messageWrapperModel: MessageWrapperModel<RegFormResModel>,
//        data: List<String>
//    ): String {
//        return certReqRepository.createCertReqModel(
//            messageWrapperModel = messageWrapperModel,
//            data = data
//        ).let { (certReqModel, rrpid) ->
//            networkAPI.sendCerReq(
//                messageWrapperJson = messageWrapperToJson(
//                    convertToDTO(
//                        changeMessageModel(
//                            messageModel = certReqModel,
//                            messageWrapperModel = messageWrapperModel,
//                            rrpid = rrpid
//                        )
//                    )
//                )
//            )
//        }
//    }
}