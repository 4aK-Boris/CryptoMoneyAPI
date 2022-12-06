package fedotkin.aleksandr.domain.models

data class NotificationModel(
    val color: String,
    val pictureUrl: String,
    val title: String,
    val text: String,
    val appId: String,
)
