package aleksandr.fedotkin.data.mappers

import aleksandr.fedotkin.data.dto.BuyerDTO
import aleksandr.fedotkin.domain.models.BuyerModel

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
