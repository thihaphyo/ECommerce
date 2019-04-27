package com.padc.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padc.ecommerce.R
import com.padc.ecommerce.adapters.ProductDetailsImageAdapter
import com.padc.ecommerce.data.models.ItemModel
import com.padc.ecommerce.data.models.ItemModelImpl
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : BaseActivity() {

    private var productID: Int = 0
    private lateinit var mProductModel: ItemModel
    private lateinit var mPagerAdapter: ProductDetailsImageAdapter

    companion object {

        fun getNewIntent(context: Context): Intent {

            val intent = Intent(context, ProductDetailsActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp)

        mProductModel = ItemModelImpl

        mPagerAdapter = ProductDetailsImageAdapter()

        vpImages.adapter = mPagerAdapter

        productID = intent.getIntExtra("pid", -1)

        val product = mProductModel.getProductByID(productID)

        if (product != null) {

            mPagerAdapter.setNewData(product.productImageUrl)
            tvItemName.text = product.productName
            tvShopName.text = product.seller.name
            tvPrice.text = product.price
            tvDesc.text = product.desc


        }

        btnFavourite.setImageResource(R.drawable.ic_favorite_red_24dp)
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }


}