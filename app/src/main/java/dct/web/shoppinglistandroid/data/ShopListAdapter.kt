package dct.web.shoppinglistandroid.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dct.web.shoppinglistandroid.R
import dct.web.shoppinglistandroid.domain.entity.ShopItem

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder> () {

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ShopItemViewHolder (val view: View): RecyclerView.ViewHolder (view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    // Показывает, как создавать элементы внутри вью
    // Вызывается для тех элементов, которые видимы на экране и еще для нескольких за экраном

    // Эти используемые вью добавляются в пул вью холдеров
    // Чтобы переиспользовать вью холдер, у него должен быть подходящий вью тип
    // Если в пуле подходящего вью холдера нет, то он создается заново

    // Пул вью холдеров содержит по умолчанию небольшую емкость,
    // поэтому желательно его увеличивать

    // ВАЖНО! В ресайклер вью мы переиспользуем уже созданные вью,
    // поэтому необходимо сбрасывать прошлые значения с вью - с помощью функции onViewRecycled

    // viewType необходим, чтобы задавать разные макеты (лэйауты) в зависимости от типа элемента
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  shopList.size
    }

    // Показывает, как вставлять значения внутри вью
    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]

        viewHolder.view.setOnClickListener{
            true
        }

        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.count.toString()

    }

    // Устанавливаем значения по умолчанию в вью
    // При переиспользовании вью, вью сбрасывается до этих значений
    // и далее уже с ними заново работаем
    override fun onViewRecycled(viewHolder: ShopItemViewHolder) {
        super.onViewRecycled(viewHolder)
        viewHolder.tvName.text = ""
        viewHolder.tvCount.text = ""
    }

    // Переопределяем его, так как у нас для разных элементов используются разные макеты
    override fun getItemViewType(position: Int): Int {
        val item = shopList[position]
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 0
        const val MAX_POOL_SIZE = 15
    }

}