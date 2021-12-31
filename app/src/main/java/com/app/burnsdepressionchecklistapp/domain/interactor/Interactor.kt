package com.app.burnsdepressionchecklistapp.domain.interactor

import com.app.burnsdepressionchecklistapp.domain.questionnaire.Questionnaire
import com.app.burnsdepressionchecklistapp.domain.TestType

interface Interactor {
    fun getQuestionnaire(type: TestType): Questionnaire
}
