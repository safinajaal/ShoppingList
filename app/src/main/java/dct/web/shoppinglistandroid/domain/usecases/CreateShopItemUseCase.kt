package dct.web.shoppinglistandroid.domain.usecases

import dct.web.shoppinglistandroid.domain.repository.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class CreateShopItemUseCase (private val shopListRepository: ShopListRepository) {

    fun createShopItem(shopItem: ShopItem) {
        shopListRepository.createShopItem(shopItem)
    }

}