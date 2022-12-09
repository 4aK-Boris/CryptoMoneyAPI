package fedotkin.aleksandr.data.mappers

import fedotkin.aleksandr.data.dto.BuyDTO
import fedotkin.aleksandr.domain.models.BuyModel

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
