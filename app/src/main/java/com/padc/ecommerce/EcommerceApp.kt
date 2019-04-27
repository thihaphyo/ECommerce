package com.padc.ecommerce

import android.app.Application
import com.padc.ecommerce.data.models.CategoryModelImpl
import com.padc.ecommerce.data.models.ItemModelImpl

class EcommerceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ItemModelImpl.initDataBase(applicationContext)
        CategoryModelImpl.initDataBase(applicationContext)
    }
}