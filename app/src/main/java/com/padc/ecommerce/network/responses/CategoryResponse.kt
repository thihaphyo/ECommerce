package com.padc.ecommerce.network.responses

import com.google.gson.annotations.SerializedName
import com.padc.ecommerce.data.vos.CategoryVO

data class CategoryResponse(

    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("apiVersion") val apiVersion: String,
    @SerializedName("page") val page: String,
    @SerializedName("categoryList") val categoryList: MutableList<CategoryVO>
) {

    fun isResponseSuccess(): Boolean {

        return code == 200 && !categoryList.isEmpty()
    }
}