package com.example.navdroid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navdroid.feature.SectionScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    bottomNavController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.PageA
    ) {
        composable(Route.PageA) { SectionScreen.BaseComposable(navController, bottomNavController,"Page A") }
        composable(Route.PageB) { SectionScreen.BaseComposable(navController, bottomNavController,"Page B") }
        composable(Route.PageC) { SectionScreen.BaseComposable(navController, bottomNavController,"Page C") }
        composable(Route.PageD) { SectionScreen.BaseComposable(navController, bottomNavController,"Page D") }
    }

    NavHost(
        navController = bottomNavController,
        startDestination = Route.PageE
    ) {
        composable(Route.PageE) { SectionScreen.BaseComposable(navController, bottomNavController,"Page E") }
        composable(Route.PageF) { SectionScreen.BaseComposable(navController, bottomNavController,"Page F") }
        composable(Route.PageG) { SectionScreen.BaseComposable(navController, bottomNavController,"Page G") }
        composable(Route.PageH) { SectionScreen.BaseComposable(navController, bottomNavController,"Page H") }
    }
}