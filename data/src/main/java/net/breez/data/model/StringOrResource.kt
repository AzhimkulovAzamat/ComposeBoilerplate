package net.breez.data.model

import android.content.Context
import androidx.annotation.StringRes

data class StringOrResource internal constructor(
    @StringRes val resourceId: Int?,
    val text: String?
) {

    constructor(@StringRes resourceId: Int) : this(resourceId, null)
    constructor(text: String) : this(null, text)

    fun getValue(context: Context): String {
        return resourceId?.let { context.getString(it) } ?: text!!
    }
}

fun String.toSOR(): StringOrResource {
    return StringOrResource(this)
}

fun Int.toSOR(): StringOrResource {
    return StringOrResource(this)
}