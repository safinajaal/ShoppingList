package dct.web.shoppinglistandroid.domain.utilities

import dct.web.shoppinglistandroid.domain.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class EditShopItemUseCase (private val shopListRepository: ShopListRepository) {

    fun editShopItem (shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }

}