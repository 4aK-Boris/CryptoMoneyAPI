package aleksandr.fedotkin.domain.di

import aleksandr.fedotkin.data.kstore.CryptoMoneyKStore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val kStoreModule = module {

    singleOf(::CryptoMoneyKStore)
}
