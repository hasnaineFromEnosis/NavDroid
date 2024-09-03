package com.example.navdroid.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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

object SectionScreen {
    private lateinit var mainNavController: NavHostController
    private lateinit var bottomNavController: NavHostController

    @Composable
    fun BaseComposable(navController: NavHostController,
                       bottomNavController: NavHostController,
                       sectionName: String) {

        this.mainNavController = navController
        this.bottomNavController = bottomNavController

        val bottomNavItems = listOf(Route.PageE, Route.PageF, Route.PageG, Route.PageH)
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBarWithBackArrow(navController,"Go Back")
            },
            bottomBar = {
                BottomNavigationBar(bottomNavController, bottomNavItems)
            }
        ) { innerPadding ->
            // This Column is used to combine NavHost and NonBottomButtons in a vertical arrangement
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                ContentBox(sectionName)
            }
        }
    }

    @Composable
    fun ContentBox(sectionName: String) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = "Welcome to $sectionName", fontSize = 24.sp)
                NonBottomButtons()
            }
        }
    }

    @Composable
    fun NonBottomSingleButton(navController: NavHostController, routeName: String) {
        Button(
            onClick = {
                NavUtilities.HandleNavigationEvent(NavEvent.NavigateFront(navController,routeName))
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(text = routeName)
        }
    }

    @Composable
    fun NonBottomButtons() {
        Column(
            modifier = Modifier.padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NonBottomSingleButton(mainNavController, Route.PageA)
            NonBottomSingleButton(mainNavController, Route.PageB)
            NonBottomSingleButton(mainNavController, Route.PageC)
            NonBottomSingleButton(mainNavController, Route.PageD)
            NonBottomSingleButton(bottomNavController, Route.PageE)
            NonBottomSingleButton(bottomNavController, Route.PageF)
            NonBottomSingleButton(bottomNavController, Route.PageG)
            NonBottomSingleButton(bottomNavController, Route.PageH)
        }
    }
}