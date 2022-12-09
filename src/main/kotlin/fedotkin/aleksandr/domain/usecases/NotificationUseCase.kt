package fedotkin.aleksandr.domain.usecases

import fedotkin.aleksandr.data.dto.notification.NotificationDTO
import fedotkin.aleksandr.domain.repositories.NotificationRepository
import fedotkin.aleksandr.services.OneSignalService

class NotificationUseCase(
    private val notificationRepository: NotificationRepository,
    private val service: OneSignalService
) {

    private suspend fun getSellerNotification(productId: Int): NotificationDTO {
        return notificationRepository.getSellerNotification(productId = productId)
    }

    private suspend fun getBuyerNotification(productId: Int): NotificationDTO {
        return notificationRepository.getBuyerNotification(productId = productId)
    }

    private suspend fun sendNotificationSeller(productId: Int, apiKey: String) {
        service.sendNotification(notificationDTO = getSellerNotification(productId = productId), apiKey = apiKey)
    }

    private suspend fun sendNotificationBuyer(productId: Int, apiKey: String) {
        service.sendNotification(notificationDTO = getBuyerNotification(productId = productId), apiKey = apiKey)
    }

    suspend fun sendNotification(productId: Int, apiKeySeller: String, apiKeyBuyer: String) {
        sendNotificationSeller(productId = productId, apiKey = apiKeySeller)
        sendNotificationBuyer(productId = productId, apiKey = apiKeyBuyer)
    }
}
