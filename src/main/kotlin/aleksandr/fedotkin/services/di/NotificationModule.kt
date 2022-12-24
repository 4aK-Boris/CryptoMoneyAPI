package aleksandr.fedotkin.services.di

import aleksandr.fedotkin.services.OneSignalService
import aleksandr.fedotkin.services.OneSignalServiceImpl
import org.koin.dsl.module

val notificationModule = module {

    single<OneSignalService> {
        OneSignalServiceImpl(client = get())
    }
}
