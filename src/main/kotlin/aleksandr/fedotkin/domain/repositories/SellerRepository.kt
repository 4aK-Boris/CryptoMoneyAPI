package aleksandr.fedotkin.domain.repositories

import aleksandr.fedotkin.data.dto.SellerDTO
import aleksandr.fedotkin.data.dto.SellerTitleDTO
import aleksandr.fedotkin.domain.models.SellerModel

interface SellerRepository {

    suspend fun getSellerDTOs(sellerModels: List<SellerModel>): List<SellerDTO>

    suspend fun getSellerModels(): List<SellerModel>

    suspend fun changeMoney(sellerId: Int, money: Int)

    suspend fun getSellerTitle(sellerId: Int): SellerTitleDTO
}
