package com.example.insbaykotlin.ui.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.insbaykotlin.common.util.CommonUtil


class TestActivity : AppCompatActivity() {
    private var isLogged = false
    private var user: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CommonUtil.saveDeviceToken(token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjQwOTU3OTgsImlhdCI6MTYyNDAwOTIxOCwic3ViIjoiLTgzIiwiaXNzIjoiRmJZR1hiTDdtNmhtR1pDVkNHbHVsZUdtRjdiUGpSaHMiLCJtZXRhIjoie1wiaWRcIjogXCItODNcIiwgXCJ1c2VybmFtZVwiOiBcImFub255bW91c1wiLCBcImNvdW50cnlcIjogXCJQTFwiLCBcInVzZXJfdHlwZVwiOiAwfSIsInJvbGUiOiJhbm9ueW1vdXMifQ.Qmw6yZQkvn3U_kMZPLbnZ9GlPODnu4x5n8rEE_vbkFE")
}

    private fun getExtra() {
     /*   var bundle = intent.getBundleExtra("Test")
        var user = bundle.getString("Test")
        Log.e("TAG", "USER: $user")
        user?.let { setupWebView(it) }*/
    }

}