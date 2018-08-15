package com.dxmnd.mos.dev

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.dxmnd.mos.dev.key_press.KeyPressActivity
import com.dxmnd.mos.dev.scroll_view_dynamic_view.ScrollDynamicActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(v: View) {
        startActivity(Intent(this, KeyPressActivity::class.java))
    }
}
