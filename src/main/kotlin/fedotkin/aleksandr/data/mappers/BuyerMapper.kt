package fedotkin.aleksandr.data.mappers

import fedotkin.aleksandr.data.dto.BuyerDTO
import fedotkin.aleksandr.domain.models.BuyerModel

class BuyerMapper {

    fun map(buyerModel: BuyerModel): BuyerDTO {
        return BuyerDTO(
            id = buyerModel.id,
            nickName = buyerModel.nickName,
            imageUrl = buyerModel.imageUrl,
            amountOfMoney = buyerModel.amountOfMoney
        )
    }
}
