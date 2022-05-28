package com.rodrigotristany.domain.contracts

import com.rodrigotristany.domain.models.GetRealStatesRequest
import com.rodrigotristany.domain.models.GetRealStatesResponse

interface RealStatesRepository {
    suspend fun getRealStates(request: GetRealStatesRequest) : GetRealStatesResponse
}