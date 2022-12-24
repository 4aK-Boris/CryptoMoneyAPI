package aleksandr.fedotkin.services

import aleksandr.fedotkin.data.dto.notification.NotificationDTO
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
}
