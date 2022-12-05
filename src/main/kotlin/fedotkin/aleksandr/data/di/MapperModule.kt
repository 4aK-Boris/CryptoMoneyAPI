package fedotkin.aleksandr.data.di

import fedotkin.aleksandr.data.mappers.BuyMapper
import fedotkin.aleksandr.data.mappers.SellerMapper
import fedotkin.aleksandr.data.mappers.BuyerMapper
import fedotkin.aleksandr.data.mappers.ProductMapper
import fedotkin.aleksandr.data.mappers.PurchaseMapper
import fedotkin.aleksandr.data.mappers.CardMapper
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
}
