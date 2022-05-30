package com.rodrigotristany.domain.models

class GetRealStatesRequest(
    page : Int,
    size : Int,
    orderBy : String
) : Request(page, size, orderBy)