package aleksandr.fedotkin.domain.usecases

import aleksandr.fedotkin.data.dto.BuyerDTO
import aleksandr.fedotkin.domain.repositories.BuyerRepository

class BuyerUseCase(
    private val buyerRepository: BuyerRepository
) {

    suspend fun getBuyers(): List<BuyerDTO> {
        return buyerRepository.getBuyerDTOs(buyerModels = buyerRepository.getBuyerModels())
    }
}
