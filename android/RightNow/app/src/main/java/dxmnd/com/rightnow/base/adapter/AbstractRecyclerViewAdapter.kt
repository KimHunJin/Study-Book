package dxmnd.com.rightnow.base.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import dxmnd.com.rightnow.base.adapter.listener.OnItemClickListener
import dxmnd.com.rightnow.base.adapter.model.BaseModel
import dxmnd.com.rightnow.base.adapter.model.BaseRecyclerView

/**
 * Created by HunJin on 2018-04-04.
 */
abstract class AbstractRecyclerViewAdapter<ITEM, VIEW_TYPE : RecyclerView.ViewHolder?>(open val context: Context)
    : RecyclerView.Adapter<VIEW_TYPE>(), BaseModel<ITEM>, BaseRecyclerView {

    override var onItemClickListener: OnItemClickListener? = null

    override fun setOnItemClickListener(listener: (RecyclerView.Adapter<*>, Int) -> Unit) {
        onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(adapter: RecyclerView.Adapter<*>, position: Int) {
                listener(adapter, position)
            }
        }
    }

    private val itemList: MutableList<ITEM> = ArrayList()

    abstract fun onItemViewType(position: Int): Int

    override fun getItemViewType(position: Int): Int = onItemViewType(position)

    override fun getItemCount(): Int = itemList.size

    override fun addItem(item: ITEM) {
        itemList.add(item)
    }

    override fun addItem(position: Int, item: ITEM) {
        itemList.add(position, item)
    }

    override fun addItems(items: List<ITEM>) {
        itemList.addAll(items)
    }

    override fun removeItem(item: ITEM) {
        itemList.remove(item)
    }

    override fun removeItem(position: Int) {
        itemList.removeAt(position)
    }

    override fun getItems() = itemList

    override fun getItem(position: Int): ITEM? = itemList.getOrNull(position)

    override fun clear() {
        itemList.clear()
    }
}