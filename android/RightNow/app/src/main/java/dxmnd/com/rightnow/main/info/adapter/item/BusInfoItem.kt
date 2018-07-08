package dxmnd.com.rightnow.main.info.adapter.item


/**
 * id : private key
 * name : bus stop name
 * number : bus stop id
 * isBus : arrived at this bus stop
 * isBookmark : user's bookmark
 * status
 *  0 : header
 *  1 : footer
 *  2 : body
 */
data class BusInfoItem(val id: Int, val name: String, val number: String, val isBus : Boolean, val isBookmark : Boolean, val status: Int = 2)