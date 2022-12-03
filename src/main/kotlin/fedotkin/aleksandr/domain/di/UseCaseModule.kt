package fedotkin.aleksandr.domain.di

import fedotkin.aleksandr.domain.usecases.BuyerUseCase
import fedotkin.aleksandr.domain.usecases.ProductUseCase
import fedotkin.aleksandr.domain.usecases.SellerUseCase
import fedotkin.aleksandr.domain.usecases.PurchaseUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {

    factoryOf(::ProductUseCase)

    factoryOf(::BuyerUseCase)

    factoryOf(::SellerUseCase)

    factoryOf(::PurchaseUseCase)
}
