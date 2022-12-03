package fedotkin.aleksandr.data.di

import fedotkin.aleksandr.data.mappers.SellerMapper
import fedotkin.aleksandr.data.mappers.BuyerMapper
import fedotkin.aleksandr.data.mappers.ProductMapper
import fedotkin.aleksandr.data.mappers.PurchaseMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val mapperModule = module {

    factoryOf(::ProductMapper)

    factoryOf(::BuyerMapper)

    factoryOf(::SellerMapper)

    factoryOf(::PurchaseMapper)

}
