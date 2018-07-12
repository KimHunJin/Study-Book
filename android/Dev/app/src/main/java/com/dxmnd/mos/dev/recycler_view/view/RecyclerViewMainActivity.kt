package com.dxmnd.mos.dev.recycler_view.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.dxmnd.mos.dev.R
import com.dxmnd.mos.dev.recycler_view.Contract
import com.dxmnd.mos.dev.recycler_view.adapter.RecyclerViewAdapter
import com.dxmnd.mos.dev.recycler_view.presenter.Presenter
import kotlinx.android.synthetic.main.activity_recycler_view_main.*

class RecyclerViewMainActivity : AppCompatActivity(), Contract.View {

    override lateinit var presenter: Contract.Presenter

    private var adapter : RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_main)


        adapter = RecyclerViewAdapter(this)

        presenter = Presenter(this)?.apply {
            this.adapterView = adapter
            this.adapterModel = adapter
        }


        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter

        fab_recycler_view.setOnClickListener {
            adapter?.apply {
                presenter.addItemClick(this)
            }
        }
    }
}
