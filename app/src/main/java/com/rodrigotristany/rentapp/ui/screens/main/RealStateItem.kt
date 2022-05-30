package com.rodrigotristany.rentapp.ui.screens.main

data class RealStateItem(
    val id: Int,
    val title: String,
    val description : String,
    val thumb: String
) {
    enum class Type { HOUSE, APARTMENT }
}

fun getItems() = (1..10).map {
    RealStateItem(
        id = it,
        title = "Title $it",
        description = "Description $it",
        thumb = "https://loremflickr.com/400/400/house?lock=$it"
    )
}