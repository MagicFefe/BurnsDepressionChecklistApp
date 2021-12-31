package com.app.burnsdepressionchecklistapp.di.domain.interactor

import com.app.burnsdepressionchecklistapp.domain.interactor.Interactor
import com.app.burnsdepressionchecklistapp.domain.interactor.impl.QuestionnaireInteractor
import dagger.Binds
import dagger.Module

@Module
interface InteractorModule {
    @Binds
    fun bindQuestionnaireInteractor(interactor: QuestionnaireInteractor): Interactor
}
