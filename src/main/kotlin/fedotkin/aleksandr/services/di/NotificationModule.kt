package fedotkin.aleksandr.services.di

import fedotkin.aleksandr.services.OneSignalService
import fedotkin.aleksandr.services.OneSignalServiceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val notificationModule = module {

    singleOf(::OneSignalServiceImpl) {
        bind<OneSignalService>()
    }
}
