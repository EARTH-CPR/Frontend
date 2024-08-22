package app.earthcpr.sol.models

import com.google.gson.annotations.SerializedName

data class JoinRequestBody(
    @SerializedName("userEmail")
    val userEmail: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("userName")
    val userName: String
)
