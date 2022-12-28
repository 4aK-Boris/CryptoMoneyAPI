package aleksandr.fedotkin.set.protocol.domain.useceses

//class RegFormReqUseCase(
//    private val regFormReqRepository: RegFormReqRepository
//) : RequestUseCase<RegFormReqModel, RegFormReq, CardCInitResTBSModel>(), BaseRepository {
//
//    override val serializer = RegFormReq.serializer()
//
//    override val convertToDTO = regFormReqRepository.convertToDTO
//
//    override val convertToModel = regFormReqRepository.convertToModel
//
//    override val rrpid: BigInteger = generateNewNumber()
//
//    override val send: suspend (String) -> String = networkAPI::sendRegForm
//
//    override suspend fun create(
//        model: CardCInitResTBSModel,
//        vararg args: String
//    ): RegFormReqModel {
//        return with(model) {
//            regFormReqRepository.createRegFormReqModel(
//                number = args.first(),
//                lidEE = lidEE,
//                lidCA = lidCA,
//                rrpid = rrpid,
//                caeThumb = caeThumb
//            )
//        }
//    }
//
//    suspend fun sendMessageWrapper(
//        messageWrapperModel: MessageWrapperModel<CardCInitReqModel>,
//        model: CardCInitResTBSModel,
//        number: String
//    ): Pair<MessageWrapperModel<RegFormReqModel>, String> {
//        return sendMessage(
//            messageWrapperModel = messageWrapperModel,
//            m = model,
//            args = arrayOf(number)
//        )
//    }
//}
