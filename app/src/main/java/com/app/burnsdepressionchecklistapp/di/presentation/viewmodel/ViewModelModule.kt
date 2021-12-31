package com.app.burnsdepressionchecklistapp.di.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.app.burnsdepressionchecklistapp.presentation.ui.screens.testing.TestingScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @CreateViewModelWithFactory(TestingScreenViewModel::class)
    fun bindTestingScreenViewModel(viewModel: TestingScreenViewModel): ViewModel
}
