package com.example.navdroid.navigation

import androidx.navigation.NavHostController

class NavUtilities private constructor() {
    companion object {
        fun HandleNavigationEvent(event: NavEvent) {
            when(event) {
                is NavEvent.BottomNavNavigate -> TODO()
                is NavEvent.Navigate -> handleNavigate(event.navController, event.route)
                is NavEvent.PopBackStack -> handlePopBackStack(event.navController)
                is NavEvent.PopUpToRoute -> TODO()
            }
        }

        private fun handleNavigate(navController: NavHostController, route: String) {
            navController.navigate(route) {
//                        popUpTo(navController.graph.findStartDestination().id) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
            }
        }

        private fun handlePopBackStack(navController: NavHostController) {
            navController.navigateUp()
        }
    }
}