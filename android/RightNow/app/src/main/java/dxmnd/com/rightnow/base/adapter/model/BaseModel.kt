package dxmnd.com.rightnow.base.adapter.model
/**
 * Created by HunJin on 2018-04-04.
 */
interface BaseModel<ITEM> {

    // add
    fun addItem(item: ITEM)

    fun addItem(position: Int, item: ITEM)

    fun addItems(items: List<ITEM>)

    // get
    fun getItems(): List<ITEM>

    fun getItem(position: Int): ITEM?

    // remove
    fun removeItem(item: ITEM)

    fun removeItem(position: Int)

    // clear
    fun clear()
}