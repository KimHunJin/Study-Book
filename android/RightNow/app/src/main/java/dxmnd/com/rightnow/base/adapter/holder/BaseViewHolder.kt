package dxmnd.com.rightnow.base.adapter.holder

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dxmnd.com.rightnow.base.adapter.AbstractRecyclerViewAdapter
import dxmnd.com.rightnow.base.adapter.listener.OnItemClickListener

/**
 * Created by HunJin on 2018-04-04.
 */


abstract class BaseViewHolder<ITEM>(open val adapter: RecyclerView.Adapter<*>, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    constructor(
            @LayoutRes layoutRes: Int,
            parent: ViewGroup?,
            adapter: RecyclerView.Adapter<*>
    ) : this(adapter,
            LayoutInflater.from((adapter as? AbstractRecyclerViewAdapter<*, *>)?.context).inflate(layoutRes, parent, false))

    init {

    }

    abstract fun onBindViewHolder(item: ITEM?, position: Int)

    protected open val context: Context?
        get() = (adapter as? AbstractRecyclerViewAdapter<*, *>)?.context

    protected val onItemClick: OnItemClickListener?
        get() = (adapter as? AbstractRecyclerViewAdapter<*, *>)?.onItemClickListener

}