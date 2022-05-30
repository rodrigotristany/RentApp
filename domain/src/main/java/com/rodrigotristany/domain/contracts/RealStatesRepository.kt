package com.rodrigotristany.domain.contracts

import com.rodrigotristany.domain.models.GetRealStatesRequest
import com.rodrigotristany.domain.models.RealState
import kotlinx.coroutines.flow.Flow

interface RealStatesRepository {
    suspend fun getRealStates(request: GetRealStatesRequest) : List<RealState>
}