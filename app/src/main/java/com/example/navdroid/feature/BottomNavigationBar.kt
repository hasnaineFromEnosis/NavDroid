package com.example.navdroid.feature

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.navdroid.navigation.Route

@Composable
fun BottomNavigationBar(navController: NavController, items: List<String>) {
    NavigationBar {
        val currentRoute = currentRoute(navController)
        items.forEachIndexed { _, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = when (item) {
                            Route.PageE -> Icons.Default.Home
                            Route.PageF -> Icons.Default.Search
                            Route.PageG -> Icons.Default.Person
                            Route.PageH -> Icons.Default.Settings
                            else -> Icons.Default.Menu
                        },
                        contentDescription = item
                    )
                },
                label = { Text(text = item) },
                selected = currentRoute == item,
                onClick = {
                    navController.navigate(item) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}