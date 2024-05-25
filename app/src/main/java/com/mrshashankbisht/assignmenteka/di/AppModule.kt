package com.mrshashankbisht.assignmenteka.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Shashank on 24-05-2024
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
}