package com.example.navdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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
    val bottomNavItems = listOf("Home", "Search", "Profile", "Settings")

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
                startDestination = "section1"
            ) {
                composable("section1") { SectionScreen("Home") }
                composable("section2") { SectionScreen("Search") }
                composable("section3") { SectionScreen("Profile") }
                composable("section4") { SectionScreen("Settings") }
            }

            // NonBottomButtons is included in the same vertical arrangement
            NonBottomButtons(navController)
        }
    }
}


@Composable
fun NonBottomButtons(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(8) { index ->
            Button(
                onClick = {
                    if (index < 4) {
                        // Navigate to bottom navigation sections based on button index
                        navController.navigate("section${index + 1}") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    } else {
                        // Handle other button actions
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text(text = "Button ${index + 1}")
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, items: List<String>) {
    NavigationBar {
        val currentRoute = currentRoute(navController)
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = when (index) {
                            0 -> Icons.Default.Home
                            1 -> Icons.Default.Search
                            2 -> Icons.Default.Person
                            else -> Icons.Default.Settings
                        },
                        contentDescription = item
                    )
                },
                label = { Text(text = item) },
                selected = currentRoute == "section${index + 1}",
                onClick = {
                    navController.navigate("section${index + 1}") {
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
fun SectionScreen(sectionName: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Welcome to $sectionName", fontSize = 24.sp)
    }
}