package fedotkin.aleksandr.core.di

import fedotkin.aleksandr.data.core.di.mapperModule
import fedotkin.aleksandr.data.core.di.networkModule
import fedotkin.aleksandr.data.core.di.repositoryModule
import fedotkin.aleksandr.domain.core.di.kStoreModule
import fedotkin.aleksandr.domain.core.di.useCaseModule
import fedotkin.aleksandr.services.di.notificationModule
import org.koin.dsl.module

val appModule = module {
    includes(useCaseModule, repositoryModule, mapperModule, kStoreModule, networkModule, notificationModule)
}
