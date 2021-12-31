package com.app.burnsdepressionchecklistapp.di.application

import com.app.burnsdepressionchecklistapp.di.data.DataModule
import com.app.burnsdepressionchecklistapp.di.domain.DomainModule
import com.app.burnsdepressionchecklistapp.di.presentation.PresentationModule
import dagger.Module

@Module(
    includes = [
        PresentationModule::class,
        DomainModule::class,
        DataModule::class
    ]
)
class ApplicationModule
