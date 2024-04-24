package dct.web.shoppinglistandroid.domain.entity

import lombok.Data

//@Data
data class ShopItem(
    public var name: String,
    public var count: Int,
    public var enabled: Boolean,
    private var id: Int = UNDEFINED_ID


) {
    companion object {
        private const val UNDEFINED_ID = -1
    }

    public fun getId (): Int {
        return id
    }

    public fun setId(id: Int) {
        this.id = id
    }

    public fun getUNDEFINED_ID(): Int {
        return UNDEFINED_ID
    }

}
