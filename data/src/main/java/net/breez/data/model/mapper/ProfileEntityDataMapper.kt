package net.breez.data.model.mapper

import net.breez.data.model.ProfileEntity
import net.breez.domain.model.GenderType
import net.breez.domain.model.ProfileModel
import net.breez.domain.model.UserTreatment
import java.util.Date
import javax.inject.Inject

class ProfileEntityDataMapper @Inject constructor() :
    BaseEntityMapper<ProfileEntity, ProfileModel>() {

    override fun transformToEntity(entity: ProfileModel): ProfileEntity {
        TODO("Not yet implemented")
    }

    override fun transformToModel(entity: ProfileEntity): ProfileModel {
        return ProfileModel(entity.first_name)
//        return ProfileModel(
//            getUserImage(entity.avatar),
//            entity.email,
//            entity.first_name,
//            entity.middle_name,
//            entity.last_name,
//            Date(),
//            entity.mobile,
//            GenderType.fromValue(entity.gender),
//            entity.email_subscribe > 0,
//            entity.sms_subscribe > 0,
//            entity.country,
//            entity.id_city,
//            getUserTreatment(entity.address_you)
//        )
    }

    private fun getUserImage(value: String): String? {
        return if (value == "https://storage.kulikov.com/storage/placeholder.jpg") {
            null
        } else {
            value
        }
    }

    private fun getUserTreatment(id: String): UserTreatment {
        return when (id) {
            "1" -> UserTreatment.NAME_AND_MIDDLE_NAME
            "2" -> UserTreatment.NAME_AND_SURNAME
            else -> UserTreatment.NAME
        }
    }
}