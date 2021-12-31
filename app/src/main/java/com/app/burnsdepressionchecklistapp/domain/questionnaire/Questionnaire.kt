package com.app.burnsdepressionchecklistapp.domain.questionnaire

interface Questionnaire {
    val questions: List<String>
    val answers: List<Pair<String, Int>>
}
