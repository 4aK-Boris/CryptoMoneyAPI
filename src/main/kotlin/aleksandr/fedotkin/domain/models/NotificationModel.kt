package aleksandr.fedotkin.domain.models

data class NotificationModel(
    val color: String,
    val pictureUrl: String,
    val androidGroup: String,
    val title: String,
    val text: String,
    val appId: String,
)
