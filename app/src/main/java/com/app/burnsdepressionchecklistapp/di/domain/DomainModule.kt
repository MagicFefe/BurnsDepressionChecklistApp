package com.app.burnsdepressionchecklistapp.di.domain

import com.app.burnsdepressionchecklistapp.di.domain.interactor.InteractorModule
import dagger.Module

@Module(
    includes = [
        InteractorModule::class
    ]
)
class DomainModule
