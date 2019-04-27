package com.padc.ecommerce.data.vos

import com.google.gson.annotations.SerializedName

data class SellerVO(

    @SerializedName("seller_id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("address") val address: String,
    @SerializedName("phone_no") val phone: String,
    @SerializedName("profile_image") val profileImage: String
)