package net.breez.data.rest

import net.breez.data.rest.api.ProfileApi

interface RestClient {
    fun getProfileApi(): ProfileApi
}