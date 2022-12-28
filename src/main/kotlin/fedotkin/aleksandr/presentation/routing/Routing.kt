package fedotkin.aleksandr.presentation.routing

import fedotkin.aleksandr.presentation.routing.applications.configureBuyers
import fedotkin.aleksandr.presentation.routing.applications.configureProducts
import fedotkin.aleksandr.presentation.routing.applications.configurePurchases
import fedotkin.aleksandr.presentation.routing.applications.configureSellers
import fedotkin.aleksandr.presentation.routing.protocol.configureSetProtocol
import io.ktor.server.application.Application

fun Application.configureRouting() {

    configureBuyers()
    configureSellers()
    configureProducts()
    configurePurchases()
    configureSetProtocol()
}
