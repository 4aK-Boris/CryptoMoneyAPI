package aleksandr.fedotkin.data.di

import aleksandr.fedotkin.data.mappers.BuyMapper
import aleksandr.fedotkin.data.mappers.SellerMapper
import aleksandr.fedotkin.data.mappers.BuyerMapper
import aleksandr.fedotkin.data.mappers.ProductMapper
import aleksandr.fedotkin.data.mappers.PurchaseMapper
import aleksandr.fedotkin.data.mappers.CardMapper
import aleksandr.fedotkin.data.mappers.NotificationMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val mapperModule = module {

    factoryOf(::ProductMapper)

    factoryOf(::BuyerMapper)

    factoryOf(::SellerMapper)

    factoryOf(::PurchaseMapper)

    factoryOf(::CardMapper)

    factory {
        BuyMapper(
            purchaseMapper = get(),
            cardMapper = get()
        )
    }

    factoryOf(::NotificationMapper)
}
