package com.example.easyepubtransfer.di

import android.content.Context
import com.example.easyepubtransfer.data.repository.UsbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUsbRepository(@ApplicationContext context: Context): UsbRepository {
        return UsbRepository(context)
    }
}