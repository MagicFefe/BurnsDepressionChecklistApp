package com.app.burnsdepressionchecklistapp.di.data

import com.app.burnsdepressionchecklistapp.di.data.repository.RepositoryModule
import dagger.Module

@Module(
    includes = [
        RepositoryModule::class
    ]
)
class DataModule
