package com.example.navdroid.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navdroid.feature.SectionScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    startDestination: String = Route.PageE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Route.PageA) { SectionScreen(navController,"Page A") }
        composable(Route.PageB) { SectionScreen(navController,"Page B") }
        composable(Route.PageC) { SectionScreen(navController,"Page C") }
        composable(Route.PageD) { SectionScreen(navController,"Page D") }
        composable(Route.PageE) { SectionScreen(navController,"Page E") }
        composable(Route.PageF) { SectionScreen(navController,"Page F") }
        composable(Route.PageG) { SectionScreen(navController,"Page G") }
        composable(Route.PageH) { SectionScreen(navController,"Page H") }
    }
}