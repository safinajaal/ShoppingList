package dct.web.shoppinglistandroid.domain.repository

import androidx.lifecycle.LiveData
import dct.web.shoppinglistandroid.domain.entity.ShopItem

interface ShopListRepository {

    fun createShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem (shopItem: ShopItem)

    fun getShopItemById(shopItemId: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

}