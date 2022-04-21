package com.example.mimascota.platform.module

import com.example.mimascota.api.CoreHomeApi
import com.example.mimascota.repositories.UserRegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {
    @Provides
    fun productRepositoryProvider(apiService: CoreHomeApi):
        UserRegisterRepository = UserRegisterRepository(apiService)
}
