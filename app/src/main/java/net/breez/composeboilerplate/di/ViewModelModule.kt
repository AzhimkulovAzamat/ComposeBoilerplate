package net.breez.composeboilerplate.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import net.breez.composeboilerplate.mvi.time.travel.debugging.TimeTravelDebugging
import net.breez.composeboilerplate.mvi.time.travel.debugging.TimeTravelDebuggingImpl
import net.breez.data.auth.wrapper.AuthWrapper
import net.breez.data.model.mapper.ProfileEntityDataMapper
import net.breez.data.repositories.ProfileDataRepository
import net.breez.data.repositories.RegistrationDataRepository
import net.breez.data.rest.RestClient
import net.breez.domain.repositories.ProfileRepository
import net.breez.domain.repositories.RegistrationRepository

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    fun provideProfileRepository(
        restClient: RestClient,
        authWrapper: AuthWrapper,
        profileEntityDataMapper: ProfileEntityDataMapper
    ): ProfileRepository {
        return ProfileDataRepository(
            restClient,
            authWrapper,
            profileEntityDataMapper
        )
    }

    @Provides
    fun provideRegistrationRepository(): RegistrationRepository {
        return RegistrationDataRepository()
    }
}