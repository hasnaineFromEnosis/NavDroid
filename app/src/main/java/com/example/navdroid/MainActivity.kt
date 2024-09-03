package com.example.navdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.navdroid.feature.BottomNavigationBar
import com.example.navdroid.feature.TopBarWithBackArrow
import com.example.navdroid.navigation.MainNavHost
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
    val bottomNavController = rememberNavController()

    MainNavHost(navController, bottomNavController)
}


