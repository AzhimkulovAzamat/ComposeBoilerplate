package net.breez.domain.model

import java.io.Serializable

data class CaptchaModel(
    val image: String,
    val captchaId: String
): Serializable
