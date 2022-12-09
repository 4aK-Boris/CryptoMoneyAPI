package fedotkin.aleksandr.data.core

import fedotkin.aleksandr.domain.core.Model

interface Mapper {

    fun <T: Model, R: DTO> map(value: T): R
}