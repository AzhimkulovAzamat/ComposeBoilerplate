package net.breez.data.auth.wrapper

import android.util.Base64
import android.util.Log
import net.breez.data.BuildConfig
import javax.inject.Inject

interface AuthWrapper {
    fun <T> wrap(onToken: (String) -> T): T
    suspend fun <T> suspendWrap(onToken: suspend (String) -> T): T
}

class AuthWrapperImpl:AuthWrapper {
    companion object {
        const val TEST_TOKEN = "505facac-53e9-4bfb-9044-4d629fa89570:"
    }

    override fun <T> wrap(onToken: (String) -> T): T {
        val token = TEST_TOKEN
        val base64 = Base64.encodeToString(token.toByteArray(), 0).replace("\n", "")
        val readyToken = "Basic $base64"

        if(BuildConfig.DEBUG) {
            Log.d("TOKEN", token)
            Log.d("TOKEN", readyToken)
        }

        return onToken(readyToken)
    }

    override suspend fun <T> suspendWrap(onToken: suspend (String) -> T): T {
        val token = TEST_TOKEN
        val base64 = Base64.encodeToString(token.toByteArray(), 0).replace("\n", "")
        val readyToken = "Basic $base64"

        if(BuildConfig.DEBUG) {
            Log.d("TOKEN", token)
            Log.d("TOKEN", readyToken)
        }

        return onToken(readyToken)
    }
}