package net.breez.domain.model

import java.io.Serializable
import java.util.Date

data class ProfileModel constructor(
//    val image: String?,
//    val email: String?,
    val firstName: String,
//    val middleName: String,
//    val lastName: String,
//    val birthDay: Date?,
//    val mobile: String,
//    val gender: GenderType,
//    var emailSubscribe: Boolean,
//    var smsSubscribe: Boolean,
//    val country: Int,
//    val cityId: Int,
//    var userTreatment: UserTreatment
) {

//    fun getUserTreatmentName(): String {
//        return when (userTreatment) {
//            UserTreatment.NAME -> firstName
//            UserTreatment.NAME_AND_MIDDLE_NAME -> "$firstName $middleName"
//            UserTreatment.NAME_AND_SURNAME -> "$firstName $lastName"
//        }
//    }
}

enum class UserTreatment(val id: String) : Serializable {
    NAME("0"),
    NAME_AND_MIDDLE_NAME("1"),
    NAME_AND_SURNAME("2")
}

enum class GenderType(val value: Int, val title: String) {
    UNDEFINED(0, "Не выбран"),
    MAN(1, "Мужчина"),
    WOMEN(2, "Женщина");

    companion object {
        fun fromValue(value: Int): GenderType {
            for (types in values()) {
                if (types.value == value) {
                    return types
                }
            }

            return UNDEFINED
        }
    }
}