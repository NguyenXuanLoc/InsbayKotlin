package com.example.insbaykotlin.common.util

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.insbaykotlin.MyApplication
import com.example.insbaykotlin.common.ext.sharedPref
import com.example.insbaykotlin.common.util.SharedPreferencesUtil.set
import com.example.insbaykotlin.common.PrefCode
import org.jetbrains.anko.ctx

object CommonUtil {

    private var tokenDefault =
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2Mjg0MjEwNTMsImlhdCI6MTYyNzU1Njg3Mywic3ViIjoiLTgzIiwiaXNzIjoiRmJZR1hiTDdtNmhtR1pDVkNHbHVsZUdtRjdiUGpSaHMiLCJtZXRhIjoie1wiaWRcIjogXCItODNcIiwgXCJ1c2VybmFtZVwiOiBcImFub255bW91c1wiLCBcImNvdW50cnlcIjogXCJQTFwiLCBcInVzZXJfdHlwZVwiOiAwfSIsInJvbGUiOiJhbm9ueW1vdXMifQ.pZhrQktHc-07-kR2aoOirH6ki0aZ4OgOAWwfMIc0Aq8"

    fun closeKeyboard(activity: AppCompatActivity) {
        val inputMethodManager =
            activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
    }

    fun closeKeyboardWhileClickOutSide(activity: AppCompatActivity, view: View?) {
        //Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view?.setOnTouchListener { _, _ ->
                closeKeyboard(activity)
                false
            }
        }

        //If a layout container, iterate over children and seed recursion.
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                closeKeyboardWhileClickOutSide(activity, innerView)
            }
        }
    }

    fun getDeviceToken(ctx: Context = MyApplication.instance.ctx): String? {
        return ctx.sharedPref.getString(PrefCode.PREF_TOKEN, tokenDefault)
    }

    fun saveDeviceToken(ctx: Context = MyApplication.instance.ctx, token: String) {
        ctx.sharedPref[PrefCode.PREF_TOKEN] = token
    }

    fun getScreenWidthAsPixel(activity: AppCompatActivity): Int {
        val dm = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dm)
        return dm.widthPixels
    }

    fun convertDpToPixel(ctx: Context?, dimensionIds: IntArray): Int {
        var result = 0
        ctx?.run {
            for (id in dimensionIds) {
                result += resources.getDimension(id).toInt()
            }
        }

        return result
    }
}