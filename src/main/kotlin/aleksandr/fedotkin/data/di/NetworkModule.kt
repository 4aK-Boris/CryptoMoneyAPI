package aleksandr.fedotkin.data.di

import aleksandr.fedotkin.data.network.configureJson
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module

val networkModule = module {

    single {
        HttpClient(CIO) {
            configureJson()
        }
    }
}
