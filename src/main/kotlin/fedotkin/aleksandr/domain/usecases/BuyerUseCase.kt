package fedotkin.aleksandr.domain.usecases

import fedotkin.aleksandr.data.dto.BuyerDTO
import fedotkin.aleksandr.domain.repositories.BuyerRepository

class BuyerUseCase(
    private val buyerRepository: BuyerRepository
) {

    suspend fun getBuyers(): List<BuyerDTO> {
        return buyerRepository.getBuyerDTOs(buyerModels = buyerRepository.getBuyerModels())
    }
}
