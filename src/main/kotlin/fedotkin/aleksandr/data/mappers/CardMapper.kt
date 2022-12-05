package fedotkin.aleksandr.data.mappers

import fedotkin.aleksandr.data.dto.CardDTO
import fedotkin.aleksandr.domain.models.CardModel

class CardMapper {

    fun map(cardDTO: CardDTO): CardModel {
        return CardModel(
            number = cardDTO.number,
            month = cardDTO.month,
            year = cardDTO.year,
            cvc = cardDTO.cvc
        )
    }
}
