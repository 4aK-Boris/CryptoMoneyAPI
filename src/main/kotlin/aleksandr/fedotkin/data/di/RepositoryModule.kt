package aleksandr.fedotkin.data.di

import aleksandr.fedotkin.data.repositories.BuyerRepositoryImpl
import aleksandr.fedotkin.data.repositories.NotificationRepositoryImpl
import aleksandr.fedotkin.data.repositories.ProductRepositoryImpl
import aleksandr.fedotkin.data.repositories.PurchaseRepositoryImpl
import aleksandr.fedotkin.data.repositories.SellerRepositoryImpl
import aleksandr.fedotkin.domain.repositories.BuyerRepository
import aleksandr.fedotkin.domain.repositories.NotificationRepository
import aleksandr.fedotkin.domain.repositories.ProductRepository
import aleksandr.fedotkin.domain.repositories.PurchaseRepository
import aleksandr.fedotkin.domain.repositories.SellerRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<ProductRepository> {
        ProductRepositoryImpl(productMapper = get(), cryptoMoneyKStore = get())
    }

    factory<BuyerRepository> {
        BuyerRepositoryImpl(buyerMapper = get(), cryptoMoneyKStore = get())
    }


    factory<SellerRepository> {
        SellerRepositoryImpl(sellerMapper = get(), cryptoMoneyKStore = get())
    }

    factory<PurchaseRepository> {
        PurchaseRepositoryImpl(
            cryptoMoneyKStore = get(),
            buyerRepository = get(),
            productRepository = get(),
            sellerRepository = get(),
            purchaseMapper = get(),
            buyMapper = get()
        )
    }

    factory<NotificationRepository> {
        NotificationRepositoryImpl(productRepository = get(), notificationMapper = get())
    }
}
