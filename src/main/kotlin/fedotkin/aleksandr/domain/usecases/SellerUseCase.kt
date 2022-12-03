package fedotkin.aleksandr.domain.usecases

import fedotkin.aleksandr.data.dto.SellerDTO
import fedotkin.aleksandr.domain.repositories.SellerRepository

class SellerUseCase(
    private val sellerRepository: SellerRepository
) {

    suspend fun getSellers(): List<SellerDTO> {
        return sellerRepository.getSellerDTOs(sellerModels = sellerRepository.getSellerModels())
    }
}
