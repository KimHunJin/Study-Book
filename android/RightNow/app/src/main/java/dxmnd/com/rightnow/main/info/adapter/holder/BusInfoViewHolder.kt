package dxmnd.com.rightnow.main.info.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import dxmnd.com.rightnow.R
import dxmnd.com.rightnow.base.adapter.holder.BaseViewHolder
import dxmnd.com.rightnow.main.info.adapter.item.BusInfoItem
import kotlinx.android.synthetic.main.item_bus_info.view.*

class BusInfoViewHolder(parent: ViewGroup?, adapter: RecyclerView.Adapter<*>)
    : BaseViewHolder<BusInfoItem>(R.layout.item_bus_info, parent, adapter) {
    override fun onBindViewHolder(item: BusInfoItem?, position: Int) {
        item?.let {
            visible(itemViewType)
            itemView.txt_item_bus_info_bus_stop_name.text = it.name
            itemView.txt_item_bus_info_bus_stop_id.text = it.number
            if (it.isBus) {
                itemView.img_item_bus_info_current_bus.visibility = View.VISIBLE
            } else {
                itemView.img_item_bus_info_current_bus.visibility = View.INVISIBLE
            }
            if (it.isBookmark) {
                Glide.with(context!!).load(R.drawable.ic_star_blue_24dp).into(itemView.img_item_bus_info_book_mark)
            } else {
                Glide.with(context!!).load(R.drawable.ic_star_white_24dp).into(itemView.img_item_bus_info_book_mark)
            }
        }
    }


    private fun visible(type: Int) {
        when (type) {
            0 -> {
                itemView.layout_item_bus_info_line_header.visibility = View.VISIBLE
                itemView.layout_item_bus_info_line_footer.visibility = View.GONE
                itemView.layout_item_bus_info_body.visibility = View.GONE
            }

            1 -> {
                itemView.layout_item_bus_info_line_header.visibility = View.GONE
                itemView.layout_item_bus_info_line_footer.visibility = View.VISIBLE
                itemView.layout_item_bus_info_body.visibility = View.GONE
            }

            2 -> {
                itemView.layout_item_bus_info_line_header.visibility = View.GONE
                itemView.layout_item_bus_info_line_footer.visibility = View.GONE
                itemView.layout_item_bus_info_body.visibility = View.VISIBLE
            }
        }
    }

}