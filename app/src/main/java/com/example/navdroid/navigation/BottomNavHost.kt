package com.example.navdroid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navdroid.feature.SectionScreen

@Composable
fun BottomNavHost(
    navController: NavHostController,
    bottomNavController: NavHostController
) {
    NavHost(
        navController = bottomNavController,
        startDestination = Route.PageE
    ) {
        composable(Route.PageE) { SectionScreen.BaseComposable(navController, bottomNavController,"Page E", isBottomNavigationScreen = true) }
        composable(Route.PageF) { SectionScreen.BaseComposable(navController, bottomNavController,"Page F", isBottomNavigationScreen = true) }
        composable(Route.PageG) { SectionScreen.BaseComposable(navController, bottomNavController,"Page G", isBottomNavigationScreen = true) }
        composable(Route.PageH) { SectionScreen.BaseComposable(navController, bottomNavController,"Page H", isBottomNavigationScreen = true) }
    }
}