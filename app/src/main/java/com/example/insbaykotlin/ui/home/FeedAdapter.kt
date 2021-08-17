package com.example.insbaykotlin.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.setImage
import com.example.insbaykotlin.data.model.FeedModel
import com.example.insbaykotlin.data.model.ImageModel
import com.facebook.drawee.view.SimpleDraweeView

class FeedAdapter(
    var activity: AppCompatActivity,
    var models: ArrayList<FeedModel>,
    var itemClickListener: (FeedModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_LOADING = 0
    private val VIEW_TYPE_NORMAL = 1
    private var isLoaderVisible = false

    fun addLoadingView() {
        isLoaderVisible = true
        models.add(FeedModel())
        notifyItemInserted(models.size - 1)
    }

    fun removeLoadingView() {
        isLoaderVisible = false
        var position = models.size - 1
        models.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoaderVisible) {
            when (position) {
                models.size - 1 -> VIEW_TYPE_LOADING
                else -> VIEW_TYPE_NORMAL
            }
        } else VIEW_TYPE_NORMAL
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_NORMAL) {
            var view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.item_k_feed, parent, false)
            ItemHolder(view)
        } else {
            var view: View =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_load_more_vertical, parent, false)
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

    override fun getItemCount(): Int {
        return models.size
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var sdvAvatar: SimpleDraweeView = itemView.findViewById(R.id.sdv_avatar)
        private var lblUserName: TextView = itemView.findViewById(R.id.lbl_userName)
        private var sdvImage: SimpleDraweeView = itemView.findViewById(R.id.sdv_image)
        private val list by lazy { ArrayList<ImageModel>() }
        private val adapterImage by lazy {
            ImageFeedAdapter(list, activity) {

            }
        }

        fun bind(model: FeedModel) {
            with(model) {
                sdvAvatar.setImage(userInfo?.avatar?.file_url?.i200)
                lblUserName.text = userInfo?.name
                model.images?.let {
                    sdvImage.setImage(it[0].file_url.i400)
                }
                model.images?.let {
                    list.addAll(model?.images)
                    adapterImage.notifyDataSetChanged()
                }
            }
        }
    }

    inner class ItemLoadMore(itemView: View) : RecyclerView.ViewHolder(itemView)

}