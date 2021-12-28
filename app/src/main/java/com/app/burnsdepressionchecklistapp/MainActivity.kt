package com.app.burnsdepressionchecklistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgs
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.burnsdepressionchecklistapp.ui.screens.MainScreen
import com.app.burnsdepressionchecklistapp.ui.screens.ResultScreen
import com.app.burnsdepressionchecklistapp.ui.screens.TestingScreen
import com.app.burnsdepressionchecklistapp.ui.theme.BurnsDepressionChecklistAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BurnsDepressionChecklistAppTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable(route = "home") {
                            MainScreen(navController = navController)
                        }
                        composable(route = "testing") {
                            TestingScreen(navController = navController)
                        }
                        composable(
                            route = "result/{points}",
                            arguments = listOf(navArgument("points") { type = NavType.IntType })
                        ) { backStackEntry ->
                            ResultScreen(
                                navController = navController,
                                backStackEntry.arguments?.getInt("points") ?: -1
                            )
                        }
                    }
                }
            }
        }
    }
}
