package com.padc.ecommerce.delegates

interface BaseNetworkDelegate<T> {

    fun onSuccess(data:T)

    fun onFail(error:String)
}