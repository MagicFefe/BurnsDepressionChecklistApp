package com.app.burnsdepressionchecklistapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.burnsdepressionchecklistapp.ui.components.BurnsDepressionChecklistButton
import com.app.burnsdepressionchecklistapp.ui.components.BurnsDepressionChecklistTopBar
import com.app.burnsdepressionchecklistapp.ui.theme.BurnsDepressionChecklistAppTheme

@Composable
fun MainScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            BurnsDepressionChecklistTopBar(
                title = "Шкала депрессии Бернса"
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            BurnsDepressionChecklistButton(
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
fun MainScreen_Preview() {
    BurnsDepressionChecklistAppTheme {
        MainScreen(navController = rememberNavController())
    }
}
