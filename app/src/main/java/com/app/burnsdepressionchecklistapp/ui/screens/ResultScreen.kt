package com.app.burnsdepressionchecklistapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.burnsdepressionchecklistapp.R
import com.app.burnsdepressionchecklistapp.ui.components.BurnsDepressionChecklistTopBar
import com.app.burnsdepressionchecklistapp.ui.theme.BurnsDepressionChecklistAppTheme

@Composable
fun ResultScreen(
    navController: NavController,
    points: Int
) {
    Scaffold(
        topBar = {
            BurnsDepressionChecklistTopBar(
                title = "Результаты",
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack(
                            route = "testing",
                            inclusive = true
                        )
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(top = 120.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val conclusion = when(points) {
                in 6..10 -> {
                    "Нормальное, но несчастливое состояние"
                }
                in 11..25 -> {
                    "Слабо выраженная депрессия"
                }
                in 26..50 -> {
                    "Умеренная депрессия"
                }
                in 51..75 -> {
                    "Сильно выраженная депрессия"
                }
                in 76..100 -> {
                    "Крайняя степень депрессии"
                }
                else -> {
                    "Депрессия отстутствует"
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "$points/100",
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = conclusion,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun ResultScreen_Preview() {
    BurnsDepressionChecklistAppTheme {
        ResultScreen(rememberNavController(), 76)
    }
}