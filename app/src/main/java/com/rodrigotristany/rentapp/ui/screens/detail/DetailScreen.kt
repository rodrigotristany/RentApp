package com.rodrigotristany.rentapp.ui.screens.detail

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.rodrigotristany.rentapp.ui.screens.main.getItems
import com.rodrigotristany.rentapp.ui.shared.ArrowBackIcon
import com.rodrigotristany.rentapp.ui.shared.Thumb

@Composable
fun DetailScreen(mediaId: Int, onUpClick: () -> Unit) {
    val realStateItem = remember { getItems().first { it.id == mediaId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = realStateItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick) }
            )
        }
    ) {
        Thumb(realStateItem = realStateItem)
    }
}
