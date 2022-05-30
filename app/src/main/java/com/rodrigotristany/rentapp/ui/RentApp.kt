package com.rodrigotristany.rentapp.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.rodrigotristany.rentapp.ui.theme.RentAppTheme

@Composable
fun RentApp(content: @Composable () -> Unit) {
    RentAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}