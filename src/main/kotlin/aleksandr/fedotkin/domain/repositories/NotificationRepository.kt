package aleksandr.fedotkin.domain.repositories

import aleksandr.fedotkin.data.dto.notification.NotificationDTO

interface NotificationRepository {

    suspend fun getSellerNotification(productId: Int): NotificationDTO

    suspend fun getBuyerNotification(productId: Int): NotificationDTO
}
