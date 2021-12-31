package com.app.burnsdepressionchecklistapp.data

import com.app.burnsdepressionchecklistapp.domain.questionnaire.Questionnaire
import com.app.burnsdepressionchecklistapp.domain.repository.Repository
import com.app.burnsdepressionchecklistapp.domain.questionnaire.impl.BurnsDepressionChecklist
import com.app.burnsdepressionchecklistapp.domain.TestType

class QuestionnaireRepository: Repository {
    override fun getQuestionnaire(type: TestType): Questionnaire = when(type) {
        TestType.BURNS_DEPRESSION_CHECKLIST -> {
            BurnsDepressionChecklist()
        }
    }
}
