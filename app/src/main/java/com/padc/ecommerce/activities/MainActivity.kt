package com.padc.ecommerce.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.padc.ecommerce.R
import com.padc.ecommerce.adapters.CategoryRecyclerAdapter
import com.padc.ecommerce.adapters.ItemRecyclerViewAdapter
import com.padc.ecommerce.data.models.CategoryModel
import com.padc.ecommerce.data.models.CategoryModelImpl
import com.padc.ecommerce.data.models.ItemModel
import com.padc.ecommerce.data.models.ItemModelImpl
import com.padc.ecommerce.data.vos.CategoryVO
import com.padc.ecommerce.data.vos.ItemVO
import com.padc.ecommerce.delegates.ItemActionDelegate

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var mCategoryAdapter: CategoryRecyclerAdapter
    private lateinit var mItemAdapter: ItemRecyclerViewAdapter
    private lateinit var mCategoryModel: CategoryModel
    private lateinit var mItemModel: ItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mCategoryModel = CategoryModelImpl
        mItemModel = ItemModelImpl

        mCategoryAdapter = CategoryRecyclerAdapter(applicationContext)
        rvCategory.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = mCategoryAdapter

        val mCategoryList = mCategoryModel.loadCategory(
            "b002c7e1a528b7cb460933fc2875e916",
            1,
            object : CategoryModel.CategoryDelegate {

                override fun onSuccess(data: MutableList<CategoryVO>) {

                    mCategoryAdapter.setNewData(data)

                }

                override fun onFail(err: String) {

                    Toast.makeText(applicationContext, err, Toast.LENGTH_LONG).show()
                }

            })

        if (mCategoryList != null && mCategoryList.isNotEmpty()) {

            mCategoryAdapter.setNewData(mCategoryList)
        }

        mItemAdapter = ItemRecyclerViewAdapter(applicationContext

            /*anonymous inner class in java new ItemActionDelegate(){.......}*/

            , object : ItemActionDelegate {

                override fun onClickItem(item: ItemVO) {

                    val intent = ProductDetailsActivity.getNewIntent(applicationContext)
                    intent.putExtra("pid", item.productID)
                    startActivity(intent)

                }

            })

        rvItems.layoutManager = GridLayoutManager(applicationContext, 2)
        rvItems.adapter = mItemAdapter

        val productList = mItemModel.loadProducts(
            "b002c7e1a528b7cb460933fc2875e916",
            1,
            object : ItemModel.ProductDelegate {

                override fun onSuccess(data: MutableList<ItemVO>) {

                    mItemAdapter.setNewData(data)

                }

                override fun onFail(err: String) {

                    Toast.makeText(applicationContext, err, Toast.LENGTH_LONG).show()

                }

            })

        if (productList != null && productList.isNotEmpty()) {


            mItemAdapter.setNewData(productList)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
