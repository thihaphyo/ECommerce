package com.padc.ecommerce.network

import com.padc.ecommerce.network.responses.CategoryResponse
import com.padc.ecommerce.network.responses.ItemResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface EcomerceApi {

    @FormUrlEncoded
    @POST("getCategory.php")
    fun loadCategory(

        @Field("access_token") accessToken: String,
        @Field("page") page: Int

    ): Call<CategoryResponse>

    @FormUrlEncoded
    @POST("getProducts.php")
    fun loadItems(

        @Field("access_token") accessToken: String,
        @Field("page") page: Int

    ): Call<ItemResponse>
}