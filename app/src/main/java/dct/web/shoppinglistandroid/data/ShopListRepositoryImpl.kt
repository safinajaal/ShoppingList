package dct.web.shoppinglistandroid.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dct.web.shoppinglistandroid.domain.repository.ShopListRepository
import dct.web.shoppinglistandroid.domain.entity.ShopItem

object ShopListRepositoryImpl: ShopListRepository {

    // Пока храним данные в переменных вместо БД
    // В будущем необходимо переписать, чтобы в методах ниже шла работа с БД
     private val shopList = sortedSetOf<ShopItem>({o1, o2 -> o1.getId().compareTo(o2.getId())})

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 20) {
            val item = ShopItem("Name $i", i, true)
            createShopItem (item)
        }
    }

    override fun createShopItem(shopItem: ShopItem) {
        if (shopItem.getId() == shopItem.getUNDEFINED_ID()) {
            shopItem.setId(autoIncrementId++)
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
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

    override fun getShopList(): LiveData<List<ShopItem>> {
        // Делаем копию листа, чтобы работать не с исходной коллекцией
        // Тогда при изменении этого листа в другой части приложения, исходная коллекция не изменится
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}