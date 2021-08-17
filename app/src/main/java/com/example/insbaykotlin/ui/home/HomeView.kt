package com.example.insbaykotlin.ui.home

import com.example.insbaykotlin.data.model.FeedModel
import com.example.insbaykotlin.ui.base.BaseView

interface HomeView : BaseView {
    fun loadKFeedSuccess(models: List<FeedModel>, createAt: String)
}