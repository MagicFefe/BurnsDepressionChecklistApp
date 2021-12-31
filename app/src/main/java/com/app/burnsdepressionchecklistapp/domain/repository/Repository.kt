package com.app.burnsdepressionchecklistapp.domain.repository

import com.app.burnsdepressionchecklistapp.domain.TestType
import com.app.burnsdepressionchecklistapp.domain.questionnaire.Questionnaire

interface Repository {
    fun getQuestionnaire(type: TestType): Questionnaire
}
