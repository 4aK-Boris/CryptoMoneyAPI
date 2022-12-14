package fedotkin.aleksandr.domain.repositories

import fedotkin.aleksandr.data.dto.SellerDTO
import fedotkin.aleksandr.data.dto.SellerTitleDTO
import fedotkin.aleksandr.domain.models.SellerModel

interface SellerRepository {

    suspend fun getSellerDTOs(sellerModels: List<SellerModel>): List<SellerDTO>

    suspend fun getSellerModels(): List<SellerModel>

    suspend fun changeMoney(sellerId: Int, money: Int)

    suspend fun getSellerTitle(sellerId: Int): SellerTitleDTO
}
