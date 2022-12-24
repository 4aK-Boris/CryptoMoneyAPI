package aleksandr.fedotkin.presentation.exceptions

open class BaseException(val extraErrorCode: Int, override val message: String? = null) : Exception(message)

