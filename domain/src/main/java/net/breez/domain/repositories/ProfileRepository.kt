package net.breez.domain.repositories

import kotlinx.coroutines.flow.Flow
import net.breez.domain.interactor.FlowResult
import net.breez.domain.model.ProfileModel

interface ProfileRepository {

    fun getProfile(): Flow<FlowResult<ProfileModel>>
    suspend fun getOnlyProfile(): FlowResult<ProfileModel>
}