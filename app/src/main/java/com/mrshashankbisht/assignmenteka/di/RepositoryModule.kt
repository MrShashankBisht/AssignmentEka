package com.mrshashankbisht.assignmenteka.di

import com.mrshashankbisht.assignmenteka.data.repository.FormRepositoryImpl
import com.mrshashankbisht.assignmenteka.data.source.local.AppDatabase
import com.mrshashankbisht.assignmenteka.domain.FormRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Shashank on 24-05-2024
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideFormRepository(appDatabase: AppDatabase): FormRepository {
        return FormRepositoryImpl(appDatabase)
    }

}