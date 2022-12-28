package aleksandr.fedotkin.set.protocol.data.repositories.certificate.reg.form.req

//class RegFormReqRepositoryImpl(
//    private val panOnlyRepository: PANOnlyRepository,
//    private val exhRepository: EXHRepository,
//    private val regFormReqMapper: RegFormReqMapper,
//    private val keyRepository: KeyRepository,
//    private val regFormReqDataRepository: RegFormReqDataRepository
//) : RegFormReqRepository, BaseRepository() {
//
//    override val serializer = RegFormReq.serializer()
//
//    override val convertToDTO: (RegFormReqModel) -> RegFormReq = regFormReqMapper::map
//
//    override val convertToModel: (RegFormReq) -> RegFormReqModel = regFormReqMapper::map
//
//    override suspend fun createRegFormReqModel(
//        number: String,
//        lidEE: BigInteger,
//        lidCA: BigInteger,
//        rrpid: BigInteger,
//        caeThumb: ByteArray
//    ): RegFormReqModel {
//        return RegFormReqModel(
//            exh = exhRepository.encrypt(
//                publicKey = keyRepository.decodeCertificate(certificate = caeThumb).publicKey,
//                data = regFormReqDataRepository.createRegFormReqDataModel(
//                    lidEE = lidEE,
//                    lidCA = lidCA,
//                    rrpid = rrpid
//                ),
//                secondaryData = panOnlyRepository.createPANOnlyModel(number = number),
//                map = regFormReqDataRepository.convertToDTO,
//                secondaryMap = panOnlyRepository.convertToDTO,
//                serializer = regFormReqDataRepository.serializer,
//                secondarySerializer = panOnlyRepository.serializer
//            )
//        )
//    }
//}
