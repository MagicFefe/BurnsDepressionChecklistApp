package com.app.burnsdepressionchecklistapp.presentation.ui.screens.testing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.burnsdepressionchecklistapp.R
import com.app.burnsdepressionchecklistapp.domain.questionnaire.Questionnaire
import com.app.burnsdepressionchecklistapp.domain.TestType
import com.app.burnsdepressionchecklistapp.presentation.ui.components.QuestionnaireButton
import com.app.burnsdepressionchecklistapp.presentation.ui.components.QuestionnaireTopBar

@Composable
fun TestingScreen(
    navController: NavController,
    viewModel: TestingScreenViewModel
) {
    val state = viewModel.uiState
    val questionnaire = viewModel.getQuestionnaire(TestType.BURNS_DEPRESSION_CHECKLIST)
    Scaffold(
        topBar = {
            QuestionnaireTopBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_close_24),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        when (state) {
            is TestingScreenUiState.QuestionDisplayed -> {
                val numberOfQuestion = state.numberOfQuestion
                Checklist(
                    numberOfQuestion = numberOfQuestion,
                    questionnaire = questionnaire,
                    onButtonClick = { pointsForAnswer ->
                        viewModel.nextQuestion(pointsForAnswer)
                    }
                )
            }
            is TestingScreenUiState.QuestionsEnded -> {
                GoToResults(
                    onButtonClick = {
                        navController.navigate("result/${viewModel.total}")
                    }
                )
            }
        }
    }
}

@Composable
fun Checklist(
    numberOfQuestion: Int,
    questionnaire: Questionnaire,
    onButtonClick: (Int) -> Unit
) {
    val currentQuestion = questionnaire.questions[numberOfQuestion]
    val answers = questionnaire.answers
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            text = currentQuestion,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            repeat(answers.size) { index ->
                item {
                    val currentAnswer = answers[index]
                    QuestionnaireButton(
                        onClick = {
                             onButtonClick(currentAnswer.second)
                        },
                        buttonText = currentAnswer.first
                    )
                }
            }
        }
    }
}

@Composable
fun GoToResults(
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        QuestionnaireButton(
            onClick = onButtonClick,
            buttonText = "К результатам"
        )
    }
}
