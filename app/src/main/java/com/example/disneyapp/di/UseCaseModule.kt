package com.example.disneyapp.di

import com.example.disneyapp.domain.repository.CharacterRepository
import com.example.disneyapp.domain.usecase.GetCharacterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetCharacterUseCase(repository: CharacterRepository): GetCharacterUseCase {
        return GetCharacterUseCase(repository)
    }
}