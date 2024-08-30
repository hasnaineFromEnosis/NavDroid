package com.example.navdroid.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class NavUtilities private constructor() {
    companion object {
        fun HandleNavigationEvent(event: NavEvent) {
            when(event) {
                is NavEvent.NavigateFront -> handleNavigateFront(event.navController, event.route)
                is NavEvent.NavigateBack -> handleNavigateBack(event.navController)
            }
        }

        private fun handleNavigateFront(navController: NavHostController, route: String) {
            navController.navigate(route) {
                if (route == Route.PageE
                    || route == Route.PageF
                    || route == Route.PageG
                    || route == Route.PageH) {
                    popUpTo(Route.PageE) {
                        inclusive = route == Route.PageE
                    }
                }
            }
        }

        private fun handleNavigateBack(navController: NavHostController) {
            navController.navigateUp()
        }
    }
}