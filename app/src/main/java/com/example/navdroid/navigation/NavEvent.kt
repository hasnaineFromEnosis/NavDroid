package com.example.navdroid.navigation

import androidx.navigation.NavHostController

sealed class NavEvent {
    data class PopBackStack(val navController: NavHostController) : NavEvent()

    data class Navigate(val navController: NavHostController, val route: String) : NavEvent()

    data class BottomNavNavigate(val navController: NavHostController, val route: String) : NavEvent()

    data class PopUpToRoute(val route: String,val graph: String): NavEvent()
}