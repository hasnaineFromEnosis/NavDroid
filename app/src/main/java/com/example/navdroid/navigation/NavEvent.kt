package com.example.navdroid.navigation

import androidx.navigation.NavHostController

sealed class NavEvent {
    data class NavigateFront(val navController: NavHostController, val route: String) : NavEvent()

    data class NavigateBack(val navController: NavHostController) : NavEvent()
}