package com.codepath.apps.restclienttemplate.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject
@Parcelize
data class User(
    var name: String = "",
    var screeName:String = "",
    var publicImageUrl: String = ""
): Parcelable{
    companion object{
        fun fromJson(jsonObject: JSONObject):User{
            val user = User(
                name = jsonObject.getString("name"),
                screeName = jsonObject.getString("screen_name"),
                publicImageUrl = jsonObject.getString("profile_image_url_https")
            )
            return user
        }
    }
}