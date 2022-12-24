package aleksandr.fedotkin.data.mappers

import aleksandr.fedotkin.data.dto.SellerDTO
import aleksandr.fedotkin.data.dto.SellerTitleDTO
import aleksandr.fedotkin.domain.models.SellerModel

class SellerMapper {

    fun map(sellerModel: SellerModel): SellerDTO {
        return SellerDTO(
            id = sellerModel.id,
            imageUrl = sellerModel.imageUrl,
            title = sellerModel.title,
            amountOfMoney = sellerModel.amountOfMoney
        )
    }

    fun mapSellerTitle(sellerModel: SellerModel): SellerTitleDTO {
        return SellerTitleDTO(title = sellerModel.title)
    }
}
