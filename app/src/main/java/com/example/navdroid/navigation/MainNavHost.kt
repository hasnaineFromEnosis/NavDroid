package com.example.navdroid.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.navdroid.feature.SectionScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    bottomNavController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.MainRoute,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        },
        popEnterTransition = {
            EnterTransition.None
        },
        popExitTransition = {
            ExitTransition.None
        },
    ) {
        navigation(
            startDestination = Route.BaseScreen,
            route = Route.MainRoute
        ) {
            composable(Route.BaseScreen) {SectionScreen.BaseComposable(
                navController,
                bottomNavController,
                sectionName = "",
                isBaseScreen = true
            )}

            composable(Route.PageA) { SectionScreen.BaseComposable(navController, bottomNavController,"Page A") }
            composable(Route.PageB) { SectionScreen.BaseComposable(navController, bottomNavController,"Page B") }
            composable(Route.PageC) { SectionScreen.BaseComposable(navController, bottomNavController,"Page C") }
            composable(Route.PageD) { SectionScreen.BaseComposable(navController, bottomNavController,"Page D") }
        }
    }
}