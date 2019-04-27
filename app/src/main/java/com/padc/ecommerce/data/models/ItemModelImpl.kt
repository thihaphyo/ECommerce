package com.padc.ecommerce.data.models

import android.content.Context
import com.padc.ecommerce.data.vos.ItemVO
import com.padc.ecommerce.delegates.ItemDataResponseDelegate
import com.padc.ecommerce.network.EcommerceDataAgent
import com.padc.ecommerce.network.EcommerceDataAgentImpl
import com.padc.ecommerce.persistence.EcommerceDB
import java.lang.RuntimeException

object ItemModelImpl : ItemModel {

    private val mDataAgent: EcommerceDataAgent = EcommerceDataAgentImpl
    private lateinit var mDataBase: EcommerceDB


    fun initDataBase(context: Context) {

        mDataBase = EcommerceDB.getDatabase(context)
    }


    override fun loadProducts(
        accessToken: String
        , page: Int
        , delegate: ItemModel.ProductDelegate
    ): MutableList<ItemVO>? {

        if (mDataBase.isProductEmpty()) {

            mDataAgent.loadItems(
                accessToken,
                page,
                object : ItemDataResponseDelegate {

                    override fun onSuccess(data: MutableList<ItemVO>) {

                        mDataBase.productDao().insertProduct(data)
                        val list = mDataBase.productDao().getAllProduct()
                        delegate.onSuccess(list)

                    }

                    override fun onFail(error: String) {

                        delegate.onFail(error)

                    }

                })

        } else {

            val dataList = mDataBase.productDao().getAllProduct()
            return dataList
        }

        return null

    }


    override fun getProductByID(id: Int): ItemVO? {

        return mDataBase.productDao().getProductByID(id)

    }
}