package com.example.navdroid.feature

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.navdroid.navigation.NavEvent
import com.example.navdroid.navigation.NavUtilities

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithBackArrow(
    navController: NavHostController,
    title: String
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = {
                NavUtilities.HandleNavigationEvent(NavEvent.PopBackStack(navController))
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}