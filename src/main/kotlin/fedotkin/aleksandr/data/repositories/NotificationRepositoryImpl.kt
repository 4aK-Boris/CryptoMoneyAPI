package fedotkin.aleksandr.data.repositories

import fedotkin.aleksandr.data.dto.notification.NotificationDTO
import fedotkin.aleksandr.data.mappers.NotificationMapper
import fedotkin.aleksandr.domain.models.NotificationModel
import fedotkin.aleksandr.domain.repositories.NotificationRepository
import fedotkin.aleksandr.domain.repositories.ProductRepository
import fedotkin.aleksandr.services.OneSignalService

class NotificationRepositoryImpl(
    private val productRepository: ProductRepository,
    private val notificationMapper: NotificationMapper
): NotificationRepository {

    override suspend fun getSellerNotification(productId: Int): NotificationDTO {
        val productModel = productRepository.getProductModel(productId = productId)
        val notificationModel = NotificationModel(
            color = COLOR,
            pictureUrl = productModel.imageUrl,
            title = "У вас был куплен товар",
            text = productModel.title,
            appId = OneSignalService.ONE_SIGNAL_APP_ID_SELLER
        )
        return notificationMapper.map(notificationModel = notificationModel)
    }

    override suspend fun getBuyerNotification(productId: Int): NotificationDTO {
        val productModel = productRepository.getProductModel(productId = productId)
        val notificationModel = NotificationModel(
            color = COLOR,
            pictureUrl = productModel.imageUrl,
            title = "У вас был куплен товар",
            text = productModel.title,
            appId = OneSignalService.ONE_SIGNAL_APP_ID_BUYER
        )
        return notificationMapper.map(notificationModel = notificationModel)
    }

    companion object {
        private const val COLOR = "FF7AFFFF"
    }
}
