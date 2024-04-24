package dct.web.shoppinglistandroid.domain.usecases

import dct.web.shoppinglistandroid.domain.repository.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class EditShopItemUseCase (private val shopListRepository: ShopListRepository) {

    fun editShopItem (shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }

}