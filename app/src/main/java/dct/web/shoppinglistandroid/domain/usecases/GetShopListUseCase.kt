package dct.web.shoppinglistandroid.domain.usecases

import androidx.lifecycle.LiveData
import dct.web.shoppinglistandroid.domain.repository.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class GetShopListUseCase (private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }

}