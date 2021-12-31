package com.app.burnsdepressionchecklistapp.di.component

import com.app.burnsdepressionchecklistapp.QuestionnaireApp
import com.app.burnsdepressionchecklistapp.di.application.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class
    ]
)
@Singleton
interface ApplicationComponent : AndroidInjector<QuestionnaireApp>
