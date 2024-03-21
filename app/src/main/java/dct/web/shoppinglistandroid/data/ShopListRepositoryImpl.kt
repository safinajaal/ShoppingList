package dct.web.shoppinglistandroid.data

import dct.web.shoppinglistandroid.domain.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

object ShopListRepositoryImpl: ShopListRepository {

     private val shopList = mutableListOf<ShopItem>()
//    private val shopList: List<ShopItem> = mutableListOf()

    private var autoIncrementId = 0

    // Пока храним данные в переменных вместо БД
    // В будущем необходимо переписать, чтобы в методах ниже шла работа с БД
    override fun createShopItem(shopItem: ShopItem) {
        if (shopItem.getId() == shopItem.getUNDEFINED_ID()) {
            shopItem.setId(autoIncrementId++)
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItemById(shopItem.getId())
        shopList.remove(oldElement)
        createShopItem(shopItem)
    }

    //Пишем так, если по нашей бизнес-логике метод не может возвращать null
    // Если может, то возвращаемое значение функции ставим типом ShopItem?
    override fun getShopItemById(shopItemId: Int): ShopItem {
        return shopList.find { it.getId() == shopItemId } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}