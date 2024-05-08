package dct.web.shoppinglistandroid.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import dct.web.shoppinglistandroid.R
import dct.web.shoppinglistandroid.data.ShopListAdapter
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class MainActivity : androidx.activity.ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        // ViewModelProvider для получения инстанса
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // Подписываемся
        // Сюда будут прилетать все новые элементы
        viewModel.shopList.observe(this) {
            adapter.shopList = it
        }
    }

    private fun setupRecyclerView() {
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        adapter = ShopListAdapter()
        rvShopList.adapter = adapter

    }


}