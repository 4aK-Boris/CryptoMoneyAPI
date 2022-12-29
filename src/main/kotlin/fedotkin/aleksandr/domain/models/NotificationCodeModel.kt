package fedotkin.aleksandr.domain.models

data class NotificationCodeModel(
    val color: String,
    val androidGroup: String,
    val title: String,
    val text: String,
    val appId: String,
)
