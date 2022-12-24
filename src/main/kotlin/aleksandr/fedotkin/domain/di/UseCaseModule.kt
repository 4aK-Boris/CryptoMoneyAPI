package aleksandr.fedotkin.domain.di

import aleksandr.fedotkin.domain.usecases.BuyerUseCase
import aleksandr.fedotkin.domain.usecases.ProductUseCase
import aleksandr.fedotkin.domain.usecases.SellerUseCase
import aleksandr.fedotkin.domain.usecases.PurchaseUseCase
import aleksandr.fedotkin.domain.usecases.NotificationUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {

    factoryOf(::ProductUseCase)

    factoryOf(::BuyerUseCase)

    factoryOf(::SellerUseCase)

    factoryOf(::PurchaseUseCase)

    factoryOf(::NotificationUseCase)
}
