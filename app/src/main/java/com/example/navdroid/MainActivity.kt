package com.example.navdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navdroid.navigation.Route
import com.example.navdroid.ui.theme.NavDroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavDroidTheme {
                MainPage() // Set the MainPage composable as the content
            }
        }
    }
}

@Composable
fun MainPage() {
    val navController = rememberNavController()
    val bottomNavItems = listOf(Route.PageE, Route.PageF, Route.PageG, Route.PageH)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController, bottomNavItems)
        }
    ) { innerPadding ->
        // This Column is used to combine NavHost and NonBottomButtons in a vertical arrangement
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Navigation host for managing different screen navigations
            NavHost(
                navController = navController,
                startDestination = Route.PageE
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
    }
}

@Composable
fun NonBottomSingleButton(navController: NavController, routeName: String) {
    Button(
        onClick = {
            navController.navigate(routeName) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        modifier = Modifier.fillMaxWidth(0.8f)
    ) {
        Text(text = routeName)
    }
}

@Composable
fun NonBottomButtons(navController: NavController) {
    Column(
        modifier = Modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        NonBottomSingleButton(navController, Route.PageA)
        NonBottomSingleButton(navController, Route.PageB)
        NonBottomSingleButton(navController, Route.PageC)
        NonBottomSingleButton(navController, Route.PageD)
        NonBottomSingleButton(navController, Route.PageE)
        NonBottomSingleButton(navController, Route.PageF)
        NonBottomSingleButton(navController, Route.PageG)
        NonBottomSingleButton(navController, Route.PageH)
    }
}


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

@Composable
fun SectionScreen(navController: NavController, sectionName: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Welcome to $sectionName", fontSize = 24.sp)
            NonBottomButtons(navController)
        }
    }
}
