package com.app.burnsdepressionchecklistapp.domain.interactor.impl

import com.app.burnsdepressionchecklistapp.domain.questionnaire.Questionnaire
import com.app.burnsdepressionchecklistapp.domain.repository.Repository
import com.app.burnsdepressionchecklistapp.domain.TestType
import com.app.burnsdepressionchecklistapp.domain.interactor.Interactor
import javax.inject.Inject

class QuestionnaireInteractor @Inject constructor(
    private val questionnaireRepository: Repository
): Interactor {
    override fun getQuestionnaire(type: TestType): Questionnaire =
        questionnaireRepository.getQuestionnaire(type)
}
