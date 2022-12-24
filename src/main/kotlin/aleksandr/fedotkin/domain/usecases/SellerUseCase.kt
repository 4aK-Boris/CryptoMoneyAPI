package aleksandr.fedotkin.domain.usecases

import aleksandr.fedotkin.data.dto.SellerDTO
import aleksandr.fedotkin.data.dto.SellerTitleDTO
import aleksandr.fedotkin.domain.repositories.SellerRepository

class SellerUseCase(
    private val sellerRepository: SellerRepository
) {

    suspend fun getSellers(): List<SellerDTO> {
        return sellerRepository.getSellerDTOs(sellerModels = sellerRepository.getSellerModels())
    }

    suspend fun getSeller(sellerId: Int): SellerTitleDTO {
        return sellerRepository.getSellerTitle(sellerId = sellerId)
    }
}
