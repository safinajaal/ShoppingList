package dct.web.shoppinglistandroid.domain.usecases

import dct.web.shoppinglistandroid.domain.repository.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class GetShopItemByIdUseCase (private val shopListRepository: ShopListRepository) {

    fun getShopItemById(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItemById(shopItemId)
    }

}