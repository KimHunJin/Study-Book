package dxmnd.com.rightnow.base.adapter.model
import android.support.v7.widget.RecyclerView
import dxmnd.com.rightnow.base.adapter.listener.OnItemClickListener

/**
 * Created by HunJin on 2018-04-04.
 */
interface BaseRecyclerView {

    var onItemClickListener: OnItemClickListener?

    fun setOnItemClickListener(listener: (RecyclerView.Adapter<*>, Int)->Unit)

    fun notifyDataSetChanged()

}