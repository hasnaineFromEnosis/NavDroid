package com.example.navdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.navdroid.navigation.MainNavHost
import com.example.navdroid.ui.theme.NavDroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavDroidTheme {
                val navController = rememberNavController()
                val bottomNavController = rememberNavController()
                MainNavHost(navController, bottomNavController)
            }
        }
    }
}


