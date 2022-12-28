package aleksandr.fedotkin.set.protocol.domain.repositories.crypto

interface OAEP2Repository {

//    fun <T: Model, R: DTO> convertToModel(
//        oaep3: OAEP3,
//        map: (R) -> T,
//        serializer: KSerializer<R>
//    ): OAEP3Model<T>
//
//    fun <T: Model, R: DTO> convertToDTO(
//        oaep3Model: OAEP3Model<T>,
//        map: (T) -> R,
//        serializer: KSerializer<R>
//    ): OAEP3
//
//    suspend fun <T : Model, R : DTO> createAndEncrypt(
//        secretKey: SecretKey,
//        data: T,
//        certificate: X509Certificate,
//        map: (T) -> R,
//        serializer: KSerializer<R>
//    ): ByteArray
//
//    suspend fun <T : Model, R : DTO> encrypt(
//        model: OAEP3Model<T>,
//        certificate: X509Certificate,
//        map: (T) -> R,
//        serializer: KSerializer<R>): ByteArray
//
//    suspend fun <T : Model, R : DTO> encrypt(
//        model: OAEP3Model<T>,
//        publicKey: PublicKey,
//        map: (T) -> R,
//        serializer: KSerializer<R>
//    ): ByteArray
//
//    suspend fun <T : Model, R : DTO> decrypt(
//        data: ByteArray,
//        privateKey: PrivateKey,
//        map: (R) -> T,
//        serializer: KSerializer<R>
//    ): OAEP3Model<T>
}