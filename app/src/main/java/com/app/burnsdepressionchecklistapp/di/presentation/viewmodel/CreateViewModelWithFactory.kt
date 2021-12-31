package com.app.burnsdepressionchecklistapp.di.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class CreateViewModelWithFactory(val viewModel: KClass<out ViewModel>)
