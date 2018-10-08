package com.dxmnd.mos.mvvm.utils

import android.content.ContextWrapper
import android.support.v7.app.AppCompatActivity
import android.view.View

fun View.getParentActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}