package com.rodrigotristany.data.impl

import com.rodrigotristany.domain.contracts.RealStatesRepository
import com.rodrigotristany.domain.models.GetRealStatesRequest
import com.rodrigotristany.domain.models.RealState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RealStatesRepositoryImpl(private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) : RealStatesRepository {
    override suspend fun getRealStates(request: GetRealStatesRequest) : List<RealState> {
        return realStatesMock(request)
    }
}

fun realStatesMock(request: GetRealStatesRequest) =
    (1..request.size).map {
        RealState(
            id = request.page * request.size + it,
            title = "Title ${it + request.page * request.size}",
            description = "Description ${it + request.page * request.size}",
            thumb = "https://loremflickr.com/400/400/house?lock=${it + request.page * request.size}"
        )
}