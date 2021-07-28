package com.example.insbaykotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.insbaykotlin.common.ext.applyIOWithAndroidMainThread
import com.example.insbaykotlin.data.interactor.PubInteractor

class MainActivity : AppCompatActivity() {
    var pubInteractor: PubInteractor = PubInteractor()
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("TAG", "MAIN")
        pubInteractor.getAnonymousToken().applyIOWithAndroidMainThread().subscribe(
            { Log.e("TAG", "TOKEN: ${it.token}")
           }, {
                Log.e("TAG", "Error: ${it.message}")
                Log.e("TAG", "Error: ${it.localizedMessage}")
            }
        )
    }
}