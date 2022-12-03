package fedotkin.aleksandr.data.mappers

import fedotkin.aleksandr.data.dto.SellerDTO
import fedotkin.aleksandr.domain.models.SellerModel

class SellerMapper {

    fun map(sellerModel: SellerModel): SellerDTO {
        return SellerDTO(
            id = sellerModel.id,
            imageUrl = sellerModel.imageUrl,
            title = sellerModel.title,
            amountOfMoney = sellerModel.amountOfMoney
        )
    }
}
