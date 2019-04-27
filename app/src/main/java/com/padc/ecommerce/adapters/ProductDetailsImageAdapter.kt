package com.padc.ecommerce.adapters

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padc.ecommerce.R
import com.padc.ecommerce.data.vos.ProductImageVO
import com.padc.ecommerce.views.items.ProductDetailsViewItem

class ProductDetailsImageAdapter : PagerAdapter() {

    private var mData: MutableList<ProductImageVO> = ArrayList()

    override fun isViewFromObject(view: View, obj: Any): Boolean {

        return view === obj
    }

    override fun getCount(): Int {

        return mData.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater: LayoutInflater = LayoutInflater.from(container.context)
        val view = layoutInflater.inflate(R.layout.view_item_product, container, false)
        val data = mData[position]
        val viewItem: ProductDetailsViewItem = view as ProductDetailsViewItem
        viewItem.setData(data)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }

    fun setNewData(data: MutableList<ProductImageVO>) {

        mData = data
        notifyDataSetChanged()
    }
}