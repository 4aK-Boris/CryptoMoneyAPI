package fedotkin.aleksandr.domain.di

import fedotkin.aleksandr.data.kstore.CryptoMoneyKStore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val kStoreModule = module {

    singleOf(::CryptoMoneyKStore)
}
