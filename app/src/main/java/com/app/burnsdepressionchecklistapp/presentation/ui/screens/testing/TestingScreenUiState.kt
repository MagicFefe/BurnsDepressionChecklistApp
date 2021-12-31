package com.app.burnsdepressionchecklistapp.presentation.ui.screens.testing

sealed class TestingScreenUiState {
    class QuestionDisplayed(val numberOfQuestion: Int) : TestingScreenUiState()
    object QuestionsEnded : TestingScreenUiState()
}
