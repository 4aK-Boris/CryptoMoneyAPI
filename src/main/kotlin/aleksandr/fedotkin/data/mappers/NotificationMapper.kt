package aleksandr.fedotkin.data.mappers

import aleksandr.fedotkin.data.dto.notification.NotificationDTO
import aleksandr.fedotkin.data.dto.notification.NotificationMessageDTO
import aleksandr.fedotkin.domain.models.NotificationModel

class NotificationMapper {

    fun map(notificationModel: NotificationModel): NotificationDTO {
        return NotificationDTO(
            androidAccentColor = notificationModel.color,
            bigPicture = notificationModel.pictureUrl,
            includedSegments = listOf("All"),
            androidGroup = notificationModel.androidGroup,
            headings = NotificationMessageDTO(en = notificationModel.title),
            contents = NotificationMessageDTO(en = notificationModel.text),
            appId = notificationModel.appId
        )
    }
}
