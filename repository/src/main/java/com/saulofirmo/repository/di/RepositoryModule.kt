package com.saulofirmo.repository.di

import com.saulofirmo.repository.RepoRepository
import com.saulofirmo.repository.RepoRepositoryImpl
import com.saulofirmo.repository.UserRepository
import com.saulofirmo.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideUserRepository(impl: UserRepositoryImpl): UserRepository {
        return impl
    }

    @Provides
    fun provideRepoRepository(impl: RepoRepositoryImpl): RepoRepository {
        return impl
    }
}
