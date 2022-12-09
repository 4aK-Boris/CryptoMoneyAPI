package fedotkin.aleksandr.domain.models.set

data class OAEPModel<T>(val k: String, val hash: String, val p: T)