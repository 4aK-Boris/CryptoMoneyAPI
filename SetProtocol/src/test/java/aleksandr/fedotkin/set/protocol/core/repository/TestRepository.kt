package aleksandr.fedotkin.set.protocol.core.repository

import aleksandr.fedotkin.set.protocol.core.Test
import aleksandr.fedotkin.set.protocol.core.TestModel

interface TestRepository: BaseSetRepository<TestModel, Test> {

    suspend fun createDTO(): Test
}