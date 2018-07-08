package dxmnd.com.rightnow.main

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dxmnd.com.rightnow.R
import dxmnd.com.rightnow.main.adapter.ViewPagerAdapter
import dxmnd.com.rightnow.main.info.presenter.InfoPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_toolbar.*

class MainActivity : AppCompatActivity(){

    private lateinit var infoPresenter: InfoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        vp_main.adapter = adapter

    }
}
