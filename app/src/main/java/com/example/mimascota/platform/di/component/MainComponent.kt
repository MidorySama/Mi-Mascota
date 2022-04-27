package com.example.mimascota.platform.di.component

import com.example.mimascota.platform.module.RepositoryModule
import com.example.mimascota.platform.module.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        RetrofitModule::class,
        UserRegisterModule::class
    ]
)
interface MainComponent
