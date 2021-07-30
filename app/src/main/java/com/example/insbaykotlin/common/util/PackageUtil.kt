package com.example.insbaykotlin.common.util

import androidx.multidex.BuildConfig
import java.util.*

object PackageUtil {

    fun getPackageName(): String {
        return BuildConfig.APPLICATION_ID
    }

    fun getUUID(): String {
        return UUID.randomUUID().toString()
    }
}