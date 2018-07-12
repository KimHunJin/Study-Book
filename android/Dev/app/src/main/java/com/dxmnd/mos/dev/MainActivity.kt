package com.dxmnd.mos.dev

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dxmnd.mos.dev.recycler_view.view.RecyclerViewMainActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(v : View) {
        startActivity(Intent(this,RecyclerViewMainActivity::class.java))
    }
}
