package com.rodrigotristany.domain.models

sealed class GetRealStatesRequest(
    page : Int,
    size : Int,
    orderBy : String
) : Request(page, size, orderBy)