package fedotkin.aleksandr.data.dto.notification

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NotificationDTO(
    @SerialName("android_accent_color")
    val androidAccentColor: String,
    @SerialName("big_picture")
    val bigPicture: String,
    @SerialName("included_segments")
    val includedSegments: List<String>,
    val contents: NotificationMessageDTO,
    val headings: NotificationMessageDTO,
    @SerialName("app_id")
    val appId: String,
)
