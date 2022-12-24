package aleksandr.fedotkin.data.mappers

import aleksandr.fedotkin.data.dto.BuyDTO
import aleksandr.fedotkin.domain.models.BuyModel

class BuyMapper(
    private val purchaseMapper: PurchaseMapper,
    private val cardMapper: CardMapper
) {

    fun map(buyDTO: BuyDTO):BuyModel {
        return BuyModel(
            purchase = purchaseMapper.map(purchaseDTO = buyDTO.purchase),
            card = cardMapper.map(cardDTO = buyDTO.card)
        )
    }
}
