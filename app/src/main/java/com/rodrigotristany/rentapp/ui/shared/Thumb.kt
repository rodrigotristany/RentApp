package com.rodrigotristany.rentapp.ui.shared

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.rodrigotristany.rentapp.ui.screens.main.RealStateItem
import com.rodrigotristany.rentapp.R

@ExperimentalCoilApi
@Composable
fun Thumb(realStateItem: RealStateItem) {
    Box(
        modifier = Modifier
            .height(dimensionResource(R.dimen.cell_thumb_height))
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = realStateItem.thumb,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
//        if (realStateItem.type == RealStateItem.Type.APARTMENT) {
//            Icon(
//                Icons.Default.PlayCircleOutline,
//                contentDescription = null,
//                modifier = Modifier
//                    .size(dimensionResource(R.dimen.cell_play_icon_size))
//                    .align(Alignment.Center),
//                tint = Color.White
//            )
//        }
    }
}