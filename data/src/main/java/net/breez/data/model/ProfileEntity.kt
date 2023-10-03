package net.breez.data.model

data class ProfileEntity (
    val avatar:String,
    val email:String,
    val first_name:String,
    val middle_name:String,
    val last_name:String,
    var birth_day:String?,
    val mobile:String,
    val gender:Int,
    val email_subscribe:Int,
    val sms_subscribe:Int,
    val country:Int,
    val id_city:Int,
    val address_you: String
)