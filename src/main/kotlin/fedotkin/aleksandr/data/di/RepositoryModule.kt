package fedotkin.aleksandr.data.di

import fedotkin.aleksandr.data.repositories.ProductRepositoryImpl
import fedotkin.aleksandr.domain.repositories.ProductRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val repositoryModule = module {

    factoryOf(::ProductRepositoryImpl) {
        bind<ProductRepository>()
    }

}
