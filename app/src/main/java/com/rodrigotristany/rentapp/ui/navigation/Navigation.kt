package com.rodrigotristany.rentapp.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigotristany.rentapp.ui.screens.detail.DetailScreen
import com.rodrigotristany.rentapp.ui.screens.main.MainScreen

@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(NavItem.Main) {
            MainScreen { realStateItem ->
                navController.navigate(NavItem.Detail.createRoute(realStateItem.id))
            }
        }
        composable(NavItem.Detail) { backStackEntry ->
            DetailScreen(
                mediaId = backStackEntry.findArg(NavArg.RealStateId.key),
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(key: String): T {
    val value = arguments?.get(key)
    requireNotNull(value)
    return value as T
}