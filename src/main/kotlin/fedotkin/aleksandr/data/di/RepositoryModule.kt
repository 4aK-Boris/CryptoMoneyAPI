package fedotkin.aleksandr.data.di

import fedotkin.aleksandr.data.repositories.ProductRepositoryImpl
import fedotkin.aleksandr.data.repositories.BuyerRepositoryImpl
import fedotkin.aleksandr.data.repositories.SellerRepositoryImpl
import fedotkin.aleksandr.data.repositories.PurchaseRepositoryImpl
import fedotkin.aleksandr.data.repositories.NotificationRepositoryImpl
import fedotkin.aleksandr.domain.repositories.BuyerRepository
import fedotkin.aleksandr.domain.repositories.NotificationRepository
import fedotkin.aleksandr.domain.repositories.ProductRepository
import fedotkin.aleksandr.domain.repositories.PurchaseRepository
import fedotkin.aleksandr.domain.repositories.SellerRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val repositoryModule = module {

    factoryOf(::ProductRepositoryImpl) {
        bind<ProductRepository>()
    }

    factoryOf(::BuyerRepositoryImpl) {
        bind<BuyerRepository>()
    }

    factoryOf(::SellerRepositoryImpl) {
        bind<SellerRepository>()
    }

    factoryOf(::PurchaseRepositoryImpl) {
        bind<PurchaseRepository>()
    }

    factoryOf(::NotificationRepositoryImpl) {
        bind<NotificationRepository>()
    }
}
