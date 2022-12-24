package aleksandr.fedotkin.data.repositories

import aleksandr.fedotkin.data.dto.notification.NotificationDTO
import aleksandr.fedotkin.data.mappers.NotificationMapper
import aleksandr.fedotkin.domain.models.NotificationModel
import aleksandr.fedotkin.domain.repositories.NotificationRepository
import aleksandr.fedotkin.domain.repositories.ProductRepository
import aleksandr.fedotkin.services.OneSignalService

class NotificationRepositoryImpl(
    private val productRepository: ProductRepository,
    private val notificationMapper: NotificationMapper
): NotificationRepository {

    override suspend fun getSellerNotification(productId: Int): NotificationDTO {
        val productModel = productRepository.getProductModel(productId = productId)
        val notificationModel = NotificationModel(
            color = COLOR,
            pictureUrl = productModel.imageUrl,
            androidGroup = sellerGroup,
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
            androidGroup = buyerGroup,
            title = "Вы купили товар",
            text = productModel.title,
            appId = OneSignalService.ONE_SIGNAL_APP_ID_BUYER
        )
        return notificationMapper.map(notificationModel = notificationModel)
    }

    companion object {
        private const val COLOR = "FF7AFFFF"
        private const val buyerGroup = "H6TQMfDJ0iVoRLPa21zA5jpHXwj2tNTG"
        private const val sellerGroup = "ZeVhk6lmdlsWb8b3cN96Y5MSJWHydhbs"
    }
}
