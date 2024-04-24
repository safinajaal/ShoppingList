package dct.web.shoppinglistandroid.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dct.web.shoppinglistandroid.data.ShopListRepositoryImpl
import dct.web.shoppinglistandroid.domain.entity.ShopItem
import dct.web.shoppinglistandroid.domain.usecases.DeleteShopItemUseCase
import dct.web.shoppinglistandroid.domain.usecases.EditShopItemUseCase
import dct.web.shoppinglistandroid.domain.usecases.GetShopListUseCase

class MainViewModel : ViewModel() {

    // Так не надо лучше делать (data и presentation слой не должны знать друг о друге),
    // лучше через инъекцию зависимостей делать.
    // Перепишу, когда изучу этот раздел
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem (shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState (shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem((newItem))
    }

}