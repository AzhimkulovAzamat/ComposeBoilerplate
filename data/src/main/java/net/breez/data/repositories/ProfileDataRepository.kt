package net.breez.data.repositories

import android.view.KeyCharacterMap.UnavailableException
import net.breez.domain.model.ProfileModel
import net.breez.domain.repositories.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.breez.data.auth.wrapper.AuthWrapper
import net.breez.data.model.mapper.ProfileEntityDataMapper
import net.breez.data.rest.RestClient
import net.breez.domain.interactor.FlowResult

class ProfileDataRepository(
    private val restClient: RestClient,
    private val authWrapper: AuthWrapper,
    private val profileEntityDataMapper: ProfileEntityDataMapper
) : ProfileRepository {

    override fun getProfile(): Flow<FlowResult<ProfileModel>> {
        return flow {
            authWrapper.suspendWrap { token ->
                val response = restClient.getProfileApi().getProfile(token)
                val isBodyExist = response.isSuccessful && response.body() != null
                if (isBodyExist) {
                    val model = profileEntityDataMapper.transformToModel(response.body()!!.data)
                    emit(FlowResult.Success(model))
                } else {
                    throw UnavailableException("FUCK")
                }
            }
        }
    }
}