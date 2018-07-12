package dxmnd.com.rightnow.base.adapter.listener
import android.support.v7.widget.RecyclerView

/**
 * Created by HunJin on 2018-04-04.
 */
interface OnItemClickListener {
    fun onItemClick(adapter: RecyclerView.Adapter<*>, position: Int)
}