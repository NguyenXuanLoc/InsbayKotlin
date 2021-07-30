package com.example.insbaykotlin.ui.search

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.insbaykotlin.common.ext.setImage
import com.example.insbaykotlin.data.model.OutfitsModel
import com.facebook.drawee.view.SimpleDraweeView

class SearchLookAdapter(
    private var models: ArrayList<OutfitsModel>,
    private var itemClickListener: (OutfitsModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_LOADING = 0
    private val VIEW_TYPE_NORMAL = 1
    private var isLoaderVisible = false


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_NORMAL) {
            var view =
                LayoutInflater.from(parent.ctx).inflate(R.layout.item_look, parent, false)
            ItemHolder(view)
        } else {
            var view =
                LayoutInflater.from(parent.ctx).inflate(R.layout.layout_load_more, parent, false)
            ItemLoadMore(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (models.size > 0) {
            if (holder is ItemHolder) {
                holder.bind(models[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoaderVisible) {
            when (position) {
                models.size - 1 -> VIEW_TYPE_LOADING
                else -> VIEW_TYPE_NORMAL
            }
        } else {
            VIEW_TYPE_NORMAL
        }
        return super.getItemViewType(position)
    }

    fun addLoadingView() {
        isLoaderVisible = true
        models.add(OutfitsModel())
        notifyItemInserted(models.size - 1)
    }

    fun removeLoadingView() {
        isLoaderVisible = false
        val position = models.size - 1
        models.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var sdvLook: SimpleDraweeView =
            itemView.findViewById<SimpleDraweeView>(R.id.sdv_look)

        fun bind(model: OutfitsModel) {
            with(model) {
                Log.e("TAG","IMAGE: "+image?.file_url?.i400)
                sdvLook.setImage(image?.file_url?.i400)
            }

        }
    }

    inner class ItemLoadMore(itemView: View) : RecyclerView.ViewHolder(itemView)

}