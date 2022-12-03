package fedotkin.aleksandr.domain.di

import fedotkin.aleksandr.domain.usecases.BuyerUseCase
import fedotkin.aleksandr.domain.usecases.ProductUseCase
import fedotkin.aleksandr.domain.usecases.SellerUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory {
        ProductUseCase(
            cryptoMoneyKStore = get(),
            productRepositoryImpl = get()
        )
    }

    factory {
        BuyerUseCase(
            cryptoMoneyKStore = get(),
            buyerRepositoryImpl = get()
        )
    }

    factory {
        SellerUseCase(
            cryptoMoneyKStore = get(),
            sellerRepositoryImpl = get()
        )
    }
}
