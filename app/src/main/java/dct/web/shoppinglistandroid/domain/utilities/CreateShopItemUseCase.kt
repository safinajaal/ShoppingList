package dct.web.shoppinglistandroid.domain.utilities

import dct.web.shoppinglistandroid.domain.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class CreateShopItemUseCase (private val shopListRepository: ShopListRepository) {

    fun createShopItem(shopItem: ShopItem) {
        shopListRepository.createShopItem(shopItem)
    }

}