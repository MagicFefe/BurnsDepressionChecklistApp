package com.app.burnsdepressionchecklistapp.di.data.repository

import com.app.burnsdepressionchecklistapp.data.QuestionnaireRepository
import com.app.burnsdepressionchecklistapp.domain.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideQuestionnaireRepository(): Repository =
        QuestionnaireRepository()
}
