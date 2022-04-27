package com.example.mimascota.platform.module

import com.example.mimascota.api.CoreHomeApi
import com.example.mimascota.repositories.UserAccessRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RepositoryLogin {
    @Provides
    fun LoginRepositoryProvider(apiService: CoreHomeApi):
        UserAccessRepository = UserAccessRepository(apiService)
}
