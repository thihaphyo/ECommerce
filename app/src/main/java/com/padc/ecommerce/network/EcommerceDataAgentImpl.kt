package com.padc.ecommerce.network

import com.google.gson.Gson
import com.padc.ecommerce.delegates.CategoryDataResponseDelegate
import com.padc.ecommerce.delegates.ItemDataResponseDelegate
import com.padc.ecommerce.network.responses.CategoryResponse
import com.padc.ecommerce.network.responses.ItemResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object EcommerceDataAgentImpl : EcommerceDataAgent {

    private var mApi: EcomerceApi


    init {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://padcmyanmar.com/padc-3/final-projects/e-commerce/fun/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()

        mApi = retrofit.create(EcomerceApi::class.java)
    }

    override fun loadCategory(accessToken: String, page: Int, delegate: CategoryDataResponseDelegate) {

        val categoryApiCall = mApi.loadCategory(accessToken, page)
        categoryApiCall.enqueue(object : Callback<CategoryResponse> {

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {

                delegate.onFail(t.localizedMessage)

            }

            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {

                val categoryResponse: CategoryResponse? = response.body()

                if (categoryResponse == null) {

                    delegate.onFail("Empty Api")

                } else {

                    if (categoryResponse.isResponseSuccess()) {

                        delegate.onSuccess(categoryResponse.categoryList)

                    } else {

                        delegate.onFail(categoryResponse.message)

                    }

                }

            }

        })

    }

    /**
     * Products API
     */
    override fun loadItems(accessToken: String, page: Int, delegate: ItemDataResponseDelegate) {

        val productCall = mApi.loadItems(accessToken, page)
        productCall.enqueue(object : Callback<ItemResponse> {

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {

                delegate.onFail(t.localizedMessage)

            }

            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {

                val productResponse: ItemResponse? = response.body()

                if (productResponse == null) {

                    delegate.onFail("Empty Api")

                } else {

                    if (productResponse.isResponseSuccess()) {

                        delegate.onSuccess(productResponse.productList)

                    } else {

                        delegate.onFail(productResponse.message)

                    }

                }
            }

        })

    }
}