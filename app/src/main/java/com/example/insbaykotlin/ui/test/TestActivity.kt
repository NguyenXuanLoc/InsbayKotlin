package com.example.insbaykotlin.ui.test

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity


class TestActivity : AppCompatActivity() {
    private var isLogged = false
    private var user: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
}

    private fun getExtra() {
     /*   var bundle = intent.getBundleExtra("Test")
        var user = bundle.getString("Test")
        Log.e("TAG", "USER: $user")
        user?.let { setupWebView(it) }*/
    }

}