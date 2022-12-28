package aleksandr.fedotkin.set.protocol.domain.di

import aleksandr.fedotkin.set.protocol.core.di.certificate.CertificateQualifiers
import aleksandr.fedotkin.set.protocol.domain.useceses.BuyerCertificateUSeCase
import aleksandr.fedotkin.set.protocol.domain.useceses.client.CardCInitReqClientUseCase
import aleksandr.fedotkin.set.protocol.domain.useceses.server.CardCInitResServerUseCase
import aleksandr.fedotkin.set.protocol.domain.useceses.client.CardCInitResClientUseCase
import aleksandr.fedotkin.set.protocol.domain.useceses.server.CardCInitReqServerUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCasesModule = module {

    factory {
        BuyerCertificateUSeCase(
            cardCInitReqUseCase = get(),
            cardCInitResUseCase = get()
        )
    }

    factory {
        CardCInitReqClientUseCase(repository = get(), privateKey = get(), publicKey = get())
    }

    factory {
        CardCInitReqServerUseCase(
            cardCInitReqRepository = get(),
            privateKey = get(
                qualifier = named(
                    CertificateQualifiers.CCA
                )
            ), publicKey = get(
                qualifier = named(
                    CertificateQualifiers.CCA
                )
            )
        )
    }

    factory {
        CardCInitResClientUseCase(repository = get(), publicKey = get(), privateKey = get())
    }

    factory {
        CardCInitResServerUseCase(
            repository = get(),
            privateKey = get(
                qualifier = named(
                    CertificateQualifiers.CCA
                )
            ), publicKey = get(
                qualifier = named(
                    CertificateQualifiers.CCA
                )
            )
        )
    }
}