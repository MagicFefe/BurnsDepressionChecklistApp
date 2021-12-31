package com.app.burnsdepressionchecklistapp.presentation.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.burnsdepressionchecklistapp.presentation.ui.components.QuestionnaireButton
import com.app.burnsdepressionchecklistapp.presentation.ui.components.QuestionnaireTopBar
import com.app.burnsdepressionchecklistapp.presentation.ui.theme.BurnsDepressionChecklistAppTheme

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            QuestionnaireTopBar(
                title = "Шкала депрессии Бернса"
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            QuestionnaireButton(
                buttonText = "Пройти тест",
                onClick = {
                    navController.navigate("testing")
                }
            )
        }
    }
}

@Composable
@Preview
fun HomeScreen_Preview() {
    BurnsDepressionChecklistAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}
