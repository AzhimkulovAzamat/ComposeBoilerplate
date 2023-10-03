package net.breez.domain.interactor

import kotlinx.coroutines.flow.Flow
import net.breez.domain.model.ProfileModel
import net.breez.domain.repositories.ProfileRepository
import javax.inject.Inject

class FetchPersonalizedData @Inject constructor(
    private val profileRepository: ProfileRepository
): FlowUseCase<ProfileModel, Void>() {

    override fun doOnBackground(params: Void?): Flow<FlowResult<ProfileModel>> {
        return profileRepository.getProfile()
    }

}