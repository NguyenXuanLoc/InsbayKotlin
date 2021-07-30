package com.example.insbaykotlin.ui.search

import com.example.insbaykotlin.data.model.OutfitsModel
import com.example.task.ui.base.BaseView

interface SearchView : BaseView {
    fun loadOutfitSuccess(model: List<OutfitsModel>)
}