package com.app.burnsdepressionchecklistapp

import com.app.burnsdepressionchecklistapp.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class QuestionnaireApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.create()
}
