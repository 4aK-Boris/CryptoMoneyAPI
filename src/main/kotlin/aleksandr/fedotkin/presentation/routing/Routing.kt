package aleksandr.fedotkin.presentation.routing

import aleksandr.fedotkin.presentation.routing.applications.configureBuyers
import aleksandr.fedotkin.presentation.routing.applications.configureProducts
import aleksandr.fedotkin.presentation.routing.applications.configurePurchases
import aleksandr.fedotkin.presentation.routing.applications.configureSellers
import aleksandr.fedotkin.set.protocol.presentation.configureSetRouting
import io.ktor.server.application.Application

fun Application.configureRouting() {

    configureBuyers()
    configureSellers()
    configureProducts()
    configurePurchases()
    configureSetRouting()
}
