package com.padc.ecommerce.data.models

import android.content.Context
import com.padc.ecommerce.data.vos.CategoryVO
import com.padc.ecommerce.delegates.CategoryDataResponseDelegate
import com.padc.ecommerce.network.EcommerceDataAgent
import com.padc.ecommerce.network.EcommerceDataAgentImpl
import com.padc.ecommerce.persistence.EcommerceDB

object CategoryModelImpl : CategoryModel {

    private val mDataAgent: EcommerceDataAgent = EcommerceDataAgentImpl
    private lateinit var mDataBase: EcommerceDB

    fun initDataBase(context: Context) {

        mDataBase = EcommerceDB.getDatabase(context)

    }
    
    override fun loadCategory(
        accessToken: String,
        page: Int,
        delegate: CategoryModel.CategoryDelegate
    ): MutableList<CategoryVO>? {

        if (mDataBase.isCategoryEmpty()) {

            mDataAgent.loadCategory(accessToken,
                page,
                object : CategoryDataResponseDelegate {

                    override fun onSuccess(data: MutableList<CategoryVO>) {

                        mDataBase.categoryDao().insertCategory(data)
                        val categoeyList = mDataBase.categoryDao().getAllCategory()
                        delegate.onSuccess(categoeyList)

                    }

                    override fun onFail(error: String) {

                        delegate.onFail(error)

                    }

                })

        } else {

            val dataList = mDataBase.categoryDao().getAllCategory()
            return dataList

        }

        return null
    }

}