package fedotkin.aleksandr.domain.core.di

import fedotkin.aleksandr.domain.usecases.BuyerUseCase
import fedotkin.aleksandr.domain.usecases.ProductUseCase
import fedotkin.aleksandr.domain.usecases.SellerUseCase
import fedotkin.aleksandr.domain.usecases.PurchaseUseCase
import fedotkin.aleksandr.domain.usecases.NotificationUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {

    factoryOf(::ProductUseCase)

    factoryOf(::BuyerUseCase)

    factoryOf(::SellerUseCase)

    factoryOf(::PurchaseUseCase)

    factoryOf(::NotificationUseCase)
}
