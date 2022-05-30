package com.rodrigotristany.rentapp.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import coil.annotation.ExperimentalCoilApi
import com.rodrigotristany.domain.models.RealState
import com.rodrigotristany.rentapp.R
import com.rodrigotristany.rentapp.ui.shared.Thumb
import com.rodrigotristany.rentapp.ui.viewmodels.RealStateViewModel

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun RealStateList(
    viewModel : RealStateViewModel,
    onClick: (RealStateItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val realStateItems by viewModel.realStateItems.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        itemsIndexed(items = realStateItems) { index, item ->

            if(index == realStateItems.lastIndex) {
                viewModel.getRealStateItems()
            }

            val realStateItem = RealStateItem(item.id, item.title, item.description, item.thumb)
            RealStateListItem(
                realStateItem = realStateItem,
                onClick = { onClick(realStateItem) },
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall))
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
fun RealStateListItem(
    realStateItem: RealStateItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable { onClick() }
    ) {
        Column {
            Thumb(realStateItem)
            Title(realStateItem)
        }
    }
}

@Composable
private fun Title(realStateItem: RealStateItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = realStateItem.title,
            style = MaterialTheme.typography.h6
        )
    }
}