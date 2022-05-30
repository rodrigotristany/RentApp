package com.rodrigotristany.rentapp.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.rodrigotristany.data.impl.RealStatesRepositoryImpl
import com.rodrigotristany.rentapp.ui.RentApp
import com.rodrigotristany.rentapp.ui.viewmodels.RealStateViewModel

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun MainScreen(onClick: (RealStateItem) -> Unit) {
    RentApp {
        Scaffold (
            topBar = { MainAppBar() }
        ) { padding ->
            RealStateList(
                RealStateViewModel(RealStatesRepositoryImpl()),
                onClick = onClick,
                modifier = Modifier.padding(padding)
            )
        }
    }
}