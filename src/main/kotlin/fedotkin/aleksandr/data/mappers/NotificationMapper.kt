package fedotkin.aleksandr.data.mappers

import fedotkin.aleksandr.data.dto.notification.NotificationDTO
import fedotkin.aleksandr.data.dto.notification.NotificationMessageDTO
import fedotkin.aleksandr.domain.models.NotificationModel

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
