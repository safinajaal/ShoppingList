package dct.web.shoppinglistandroid.domain.usecases

import dct.web.shoppinglistandroid.domain.repository.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }

}