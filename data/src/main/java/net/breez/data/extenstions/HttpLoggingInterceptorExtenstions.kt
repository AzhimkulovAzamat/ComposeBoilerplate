package net.breez.data.extenstions

import net.breez.data.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

fun HttpLoggingInterceptor.setSafeLevel(level: HttpLoggingInterceptor.Level) {
    this.level = level
}