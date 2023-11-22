package net.breez.data.repositories

import net.breez.domain.interactor.FlowResult
import net.breez.domain.model.CaptchaModel
import net.breez.domain.repositories.RegistrationRepository

class RegistrationDataRepository (

) : RegistrationRepository {
    override fun getCaptcha(): FlowResult<CaptchaModel> {
        TODO("Not yet implemented")
    }
}