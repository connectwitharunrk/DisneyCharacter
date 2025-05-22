package com.example.disneyapp.presentation.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "characterList") {
        composable("characterList") {
            CharacterScreen(navController = navController)
        }
        composable(
            route = "characterDetail/{imageUrl}",
            arguments = listOf(navArgument("imageUrl") { type = NavType.StringType })
        ) { backStackEntry ->
            val imageUrl = backStackEntry.arguments?.getString("imageUrl") ?: ""
            CharacterDetailScreen(imageUrl = imageUrl)
        }
    }
}
