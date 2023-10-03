package net.breez.data.model

data class BaseResponse<T>(
    val success: Boolean,
    val status: Int,
    val data: T
)