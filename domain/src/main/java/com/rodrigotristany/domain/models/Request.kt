package com.rodrigotristany.domain.models

abstract class Request(
    var page : Int,
    var size : Int,
    val orderBy : String
)