package net.breez.composeboilerplate.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.breez.data.auth.wrapper.AuthWrapper
import net.breez.data.auth.wrapper.AuthWrapperImpl
import net.breez.data.rest.RestClient
import net.breez.data.rest.RestClientImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {


    @Provides
    @Singleton
    fun provideRestClient(): RestClient {
        return RestClientImpl("https://api-devkdk.kulikov.com/")
    }

    @Provides
    @Singleton
    fun provideAuthWrapper(
    ): AuthWrapper {
        return AuthWrapperImpl()
    }
}