package com.app.burnsdepressionchecklistapp.di.presentation

import com.app.burnsdepressionchecklistapp.di.presentation.activity.ActivityModule
import com.app.burnsdepressionchecklistapp.di.presentation.viewmodel.ViewModelModule
import dagger.Module

@Module(
    includes = [
        ActivityModule::class,
        ViewModelModule::class
    ]
)
class PresentationModule
