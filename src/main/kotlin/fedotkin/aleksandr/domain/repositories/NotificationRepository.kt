package fedotkin.aleksandr.domain.repositories

import fedotkin.aleksandr.data.dto.notification.NotificationCodeDTO
import fedotkin.aleksandr.data.dto.notification.NotificationDTO

interface NotificationRepository {

    suspend fun getSellerNotification(productId: Int): NotificationDTO

    suspend fun getBuyerNotification(productId: Int): NotificationDTO

    suspend fun getNotificationCode(code: Int): NotificationCodeDTO
}
