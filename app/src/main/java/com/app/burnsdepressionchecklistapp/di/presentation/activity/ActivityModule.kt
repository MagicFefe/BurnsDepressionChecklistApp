package com.app.burnsdepressionchecklistapp.di.presentation.activity

import com.app.burnsdepressionchecklistapp.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}
