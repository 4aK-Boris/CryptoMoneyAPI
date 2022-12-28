package aleksandr.fedotkin.set.protocol.data.di.repository

import aleksandr.fedotkin.set.protocol.core.DTO
import aleksandr.fedotkin.set.protocol.core.Model
import aleksandr.fedotkin.set.protocol.core.mapper.SetMapper
import aleksandr.fedotkin.set.protocol.data.repositories.general.MessageHeaderRepositoryImpl
import aleksandr.fedotkin.set.protocol.data.repositories.general.MessageIDRepositoryImpl
import aleksandr.fedotkin.set.protocol.data.repositories.general.MessageWrapperRepositoryImpl
import aleksandr.fedotkin.set.protocol.domain.repositories.general.MessageHeaderRepository
import aleksandr.fedotkin.set.protocol.domain.repositories.general.MessageIDRepository
import aleksandr.fedotkin.set.protocol.domain.repositories.general.MessageWrapperRepository
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val messageWrapperRepositoryModule = module {

    factory<MessageWrapperRepository<Model, DTO>> { (mapper: SetMapper<Model, DTO>) ->
        MessageWrapperRepositoryImpl(
            mapper = get { parametersOf(mapper) },
            jsonModelMapper = get { parametersOf(mapper) },
            messageHeaderRepository = get { parametersOf(mapper) },
        )
    }

    factory<MessageHeaderRepository> {
        MessageHeaderRepositoryImpl(
            mapper = get(),
            messageIDRepository = get(),
        )
    }

    factory<MessageIDRepository> { MessageIDRepositoryImpl(mapper = get()) }
}