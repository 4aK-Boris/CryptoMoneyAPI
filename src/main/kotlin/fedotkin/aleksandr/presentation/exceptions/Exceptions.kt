package fedotkin.aleksandr.presentation.exceptions


const val K_STORE_CODE = 1
class KStoreException: BaseException(extraErrorCode = K_STORE_CODE)
