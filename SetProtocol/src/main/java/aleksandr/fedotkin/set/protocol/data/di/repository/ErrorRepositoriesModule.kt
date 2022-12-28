package aleksandr.fedotkin.set.protocol.data.di.repository

import aleksandr.fedotkin.set.protocol.core.DTO
import aleksandr.fedotkin.set.protocol.core.Model
import aleksandr.fedotkin.set.protocol.core.mapper.SetMapper
import aleksandr.fedotkin.set.protocol.data.repositories.error.ErrorMsgRepositoryImpl
import aleksandr.fedotkin.set.protocol.data.repositories.error.ErrorRepositoryImpl
import aleksandr.fedotkin.set.protocol.data.repositories.error.ErrorTBSRepositoryImpl
import aleksandr.fedotkin.set.protocol.data.repositories.error.SignedErrorRepositoryImpl
import aleksandr.fedotkin.set.protocol.data.repositories.error.UnsignedErrorRepositoryImpl
import aleksandr.fedotkin.set.protocol.domain.repositories.error.ErrorMsgRepository
import aleksandr.fedotkin.set.protocol.domain.repositories.error.ErrorRepository
import aleksandr.fedotkin.set.protocol.domain.repositories.error.ErrorTBSRepository
import aleksandr.fedotkin.set.protocol.domain.repositories.error.SignedErrorRepository
import aleksandr.fedotkin.set.protocol.domain.repositories.error.UnsignedErrorRepository
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val errorRepositoriesModule = module {

    factory<ErrorRepository<Model, DTO>> { (mapper: SetMapper<Model, DTO>) ->
        ErrorRepositoryImpl(
            mapper = get { parametersOf(mapper) },
            unsignedErrorRepository = get { parametersOf(mapper) },
            signedErrorRepository = get(),
            errorTBSRepository = get { parametersOf(mapper) },
            messageWrapperRepository = get { parametersOf(mapper) }
        )
    }

    factory<SignedErrorRepository<Model, DTO>> { (mapper: SetMapper<Model, DTO>) ->
        SignedErrorRepositoryImpl(
            mapper = get(),
            signatureRepository = get { parametersOf(mapper) },
        )
    }

    factory<UnsignedErrorRepository<Model, DTO>> { (mapper: SetMapper<Model, DTO>) ->
        UnsignedErrorRepositoryImpl(
            mapper = get { parametersOf(mapper) },
            errorTBSRepository = get { parametersOf(mapper) }
        )
    }

    factory<ErrorTBSRepository<Model, DTO>> { (mapper: SetMapper<Model, DTO>) ->
        ErrorTBSRepositoryImpl(
            mapper = get { parametersOf(mapper) },
            errorMsgRepository = get { parametersOf(mapper) },
            keyRepository = get()
        )
    }

    factory<ErrorMsgRepository<Model, DTO>> { (mapper: SetMapper<Model, DTO>) ->
        ErrorMsgRepositoryImpl(
            mapper = get { parametersOf(mapper) }
        )
    }
}