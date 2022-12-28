package aleksandr.fedotkin.set.protocol.core.di

import aleksandr.fedotkin.set.protocol.core.TestMapper
import aleksandr.fedotkin.set.protocol.core.di.mappers.mappersTestModule
import aleksandr.fedotkin.set.protocol.core.repository.TestRepository
import aleksandr.fedotkin.set.protocol.core.repository.TestRepositoryImpl
import org.koin.dsl.module

val testModule = module {

    includes(mappersTestModule)

    factory {
        TestMapper(bigIntegerMapper = get(), base64Mapper = get())
    }

    factory<TestRepository> {
        TestRepositoryImpl(mapper = get())
    }
}