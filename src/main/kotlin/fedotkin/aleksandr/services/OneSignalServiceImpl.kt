package fedotkin.aleksandr.services

import fedotkin.aleksandr.data.dto.notification.NotificationCodeDTO
import fedotkin.aleksandr.data.dto.notification.NotificationDTO
import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class OneSignalServiceImpl(
    private val client: HttpClient
): OneSignalService {
        override suspend fun sendNotification(notificationDTO: NotificationDTO, apiKey: String): Boolean {
            return try {
                client.post(urlString = OneSignalService.NOTIFICATIONS) {
                    contentType(ContentType.Application.Json)
                    header("Authorization", "Basic $apiKey")
                    setBody(notificationDTO)
                }
                true
            } catch(e: Exception) {
                e.printStackTrace()
                false
            }
        }

    override suspend fun sendNotificationCode(notificationCodeDTO: NotificationCodeDTO, apiKey: String): Boolean {
        return try {
            client.post(urlString = OneSignalService.NOTIFICATIONS) {
                contentType(ContentType.Application.Json)
                header("Authorization", "Basic $apiKey")
                setBody(notificationCodeDTO)
            }
            true
        } catch(e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
