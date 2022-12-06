package fedotkin.aleksandr.di

import fedotkin.aleksandr.data.di.mapperModule
import fedotkin.aleksandr.data.di.networkModule
import fedotkin.aleksandr.data.di.repositoryModule
import fedotkin.aleksandr.domain.di.kStoreModule
import fedotkin.aleksandr.domain.di.useCaseModule
import fedotkin.aleksandr.services.di.notificationModule
import org.koin.dsl.module

val appModule = module {
    includes(useCaseModule, repositoryModule, mapperModule, kStoreModule, networkModule, notificationModule)
}
