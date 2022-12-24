package aleksandr.fedotkin.data.mappers

import aleksandr.fedotkin.data.dto.CardDTO
import aleksandr.fedotkin.domain.models.CardModel

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
