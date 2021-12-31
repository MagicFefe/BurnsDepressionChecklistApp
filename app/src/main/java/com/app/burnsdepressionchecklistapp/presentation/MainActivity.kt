package com.app.burnsdepressionchecklistapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.burnsdepressionchecklistapp.QuestionnaireApp
import com.app.burnsdepressionchecklistapp.di.presentation.viewmodel.ViewModelFactory
import com.app.burnsdepressionchecklistapp.presentation.ui.screens.home.HomeScreen
import com.app.burnsdepressionchecklistapp.presentation.ui.screens.result.ResultScreen
import com.app.burnsdepressionchecklistapp.presentation.ui.screens.testing.TestingScreen
import com.app.burnsdepressionchecklistapp.presentation.ui.screens.testing.TestingScreenViewModel
import com.app.burnsdepressionchecklistapp.presentation.ui.theme.BurnsDepressionChecklistAppTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as QuestionnaireApp).androidInjector().inject(this)
        setContent {
            BurnsDepressionChecklistAppTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable(route = "home") {
                            HomeScreen(navController = navController)
                        }
                        composable(route = "testing") {
                            TestingScreen(
                                navController = navController,
                                viewModel = viewModel(
                                    modelClass = TestingScreenViewModel::class.java,
                                    factory = viewModelFactory
                                )
                            )
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
