package net.breez.domain.repositories

import net.breez.domain.interactor.FlowResult
import net.breez.domain.model.CaptchaModel

interface RegistrationRepository {
    fun getCaptcha(): FlowResult<CaptchaModel>
}