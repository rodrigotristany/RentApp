package com.rodrigotristany.rentapp.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    internal val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList()
) {
    object Main : NavItem("main")
    object Detail : NavItem("detail", listOf(NavArg.RealStateId)) {
        fun createRoute(mediaId: Int) = "$baseRoute/$mediaId"
    }

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

}

enum class NavArg(val key: String, val navType: NavType<*>) {
    RealStateId("realStateId", NavType.IntType)
}