package com.example.navdroid.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navdroid.navigation.NavEvent
import com.example.navdroid.navigation.NavUtilities
import com.example.navdroid.navigation.Route

@Composable
fun SectionScreen(navController: NavHostController, sectionName: String) {
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

@Composable
fun NonBottomSingleButton(navController: NavHostController, routeName: String) {
    Button(
        onClick = {
            NavUtilities.HandleNavigationEvent(NavEvent.Navigate(navController,routeName))
        },
        modifier = Modifier.fillMaxWidth(0.8f)
    ) {
        Text(text = routeName)
    }
}

@Composable
fun NonBottomButtons(navController: NavHostController) {
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