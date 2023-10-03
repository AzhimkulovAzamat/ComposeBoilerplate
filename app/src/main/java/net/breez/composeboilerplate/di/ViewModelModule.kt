package net.breez.composeboilerplate.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import net.breez.data.auth.wrapper.AuthWrapper
import net.breez.data.model.mapper.ProfileEntityDataMapper
import net.breez.data.repositories.ProfileDataRepository
import net.breez.data.rest.RestClient
import net.breez.domain.repositories.ProfileRepository

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
}