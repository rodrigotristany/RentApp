package com.rodrigotristany.data.impl

import com.rodrigotristany.domain.contracts.RealStatesRepository
import com.rodrigotristany.domain.models.GetRealStatesRequest
import com.rodrigotristany.domain.models.GetRealStatesResponse

class RealStatesRepositoryImpl : RealStatesRepository {
    override suspend fun getRealStates(request: GetRealStatesRequest): GetRealStatesResponse {
        TODO("Not yet implemented")
    }
}