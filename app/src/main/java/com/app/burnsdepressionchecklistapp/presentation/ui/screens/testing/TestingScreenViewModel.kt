package com.app.burnsdepressionchecklistapp.presentation.ui.screens.testing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.app.burnsdepressionchecklistapp.domain.questionnaire.Questionnaire
import com.app.burnsdepressionchecklistapp.domain.interactor.impl.QuestionnaireInteractor
import com.app.burnsdepressionchecklistapp.domain.TestType
import javax.inject.Inject

class TestingScreenViewModel @Inject constructor(
    private val questionnaireInteractor: QuestionnaireInteractor
): ViewModel() {
    private var currentQuestion = 0
    var questions: List<String>? = null
    var uiState: TestingScreenUiState by mutableStateOf(
        TestingScreenUiState.QuestionDisplayed(
            currentQuestion
        )
    )
        private set
    var total = 0
        private set

    fun getQuestionnaire(type: TestType): Questionnaire {
        val questionnaire = questionnaireInteractor.getQuestionnaire(type)
        this.questions = questionnaire.questions
        return questionnaire
    }

    fun nextQuestion(pointsForAnswer: Int) {
        questions?.let { questions ->
            uiState = if (currentQuestion < questions.size - 1) {
                TestingScreenUiState.QuestionDisplayed(++currentQuestion)
            } else {
                TestingScreenUiState.QuestionsEnded
            }
            total += pointsForAnswer
        }
    }
}