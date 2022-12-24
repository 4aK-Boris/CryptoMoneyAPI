package aleksandr.fedotkin.core.di

import aleksandr.fedotkin.data.di.mapperModule
import aleksandr.fedotkin.data.di.networkModule
import aleksandr.fedotkin.data.di.repositoryModule
import aleksandr.fedotkin.domain.di.kStoreModule
import aleksandr.fedotkin.domain.di.useCaseModule
import aleksandr.fedotkin.services.di.notificationModule
import org.koin.dsl.module

val appModule = module {
    includes(useCaseModule, repositoryModule, mapperModule, kStoreModule, networkModule, notificationModule)
}
