package aleksandr.fedotkin.set.protocol.data.repositories.certificate.reg.form.req

//class RegFormReqDataRepositoryImpl(
//    private val regFormReqDataMapper: RegFormReqDataMapper
//): RegFormReqDataRepository, BaseRepository() {
//
//    override val serializer = RegFormReqData.serializer()
//
//    override val convertToDTO: (RegFormReqDataModel) -> RegFormReqData = regFormReqDataMapper::map
//
//    override val convertToModel: (RegFormReqData) -> RegFormReqDataModel = regFormReqDataMapper::map
//
//    override suspend fun createRegFormReqDataModel(
//        rrpid: BigInteger,
//        lidEE: BigInteger,
//        lidCA: BigInteger
//    ): RegFormReqDataModel {
//        return RegFormReqDataModel(
//            rrpID = rrpid,
//            lidEE = lidEE,
//            challEE2 = generateNewNumber(),
//            lidCA = lidCA,
//            requestType = RequestType.SIGNATURE,
//            language = Language.RUSSIAN,
//            thumbs = emptyList()
//        )
//    }
//}