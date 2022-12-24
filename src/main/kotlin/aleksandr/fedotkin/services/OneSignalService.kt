package aleksandr.fedotkin.services

import aleksandr.fedotkin.data.dto.notification.NotificationDTO

interface OneSignalService {

    suspend fun sendNotification(notificationDTO: NotificationDTO, apiKey: String): Boolean

    companion object {
        const val NOTIFICATIONS = "https://onesignal.com/api/v1/notifications"
        const val ONE_SIGNAL_APP_ID_SELLER = "0fc70cea-7c25-463e-8118-f813cd7af0f4"
        const val ONE_SIGNAL_APP_ID_BUYER = "df506608-20fc-460e-8e77-d296037b1a7a"
    }
}
