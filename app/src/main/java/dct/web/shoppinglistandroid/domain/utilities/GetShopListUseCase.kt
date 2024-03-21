package dct.web.shoppinglistandroid.domain.utilities

import dct.web.shoppinglistandroid.domain.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class GetShopListUseCase (private val shopListRepository: ShopListRepository) {

    fun getShopList(): List<ShopItem> {
        return shopListRepository.getShopList()
    }

}