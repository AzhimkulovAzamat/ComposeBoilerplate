package net.breez.data.rest.api

import net.breez.data.model.BaseResponse
import net.breez.data.model.ProfileEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApi {

    @GET("v2/client/profile")
    suspend fun getProfile(@Header("Authorization") token: String): Response<BaseResponse<ProfileEntity>>
}