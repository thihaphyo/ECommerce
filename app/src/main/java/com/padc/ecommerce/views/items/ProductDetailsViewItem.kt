package com.padc.ecommerce.views.items

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.padc.ecommerce.data.vos.ProductImageVO
import kotlinx.android.synthetic.main.view_item_product.view.*

class ProductDetailsViewItem : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    fun setData(data: ProductImageVO) {

        Glide.with(context)
            .load(data.imageUrl)
            .into(ivProduct)

    }

    override fun onFinishInflate() {
        super.onFinishInflate()

    }
}