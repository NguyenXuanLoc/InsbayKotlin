package com.example.insbaykotlin.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.ctx
import com.example.insbaykotlin.common.ext.setImage
import com.example.insbaykotlin.common.ext.setRatio
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.data.model.UsersModel
import com.facebook.drawee.view.SimpleDraweeView

class SearchTvStarAdapter(
    val activity: AppCompatActivity,
    var models: ArrayList<UsersModel>,
    val itemTvStarClickListener: (UsersModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_LOADING = 0
    private val VIEW_TYPE_NORMAL = 1
    private var isLoaderVisible = false
    private val margin = CommonUtil.convertDpToPixel(
        activity,
        intArrayOf(R.dimen.dimen_2x, R.dimen.dimen_2x, R.dimen.dimen_2x)
    )
    private var totalMargin =
        (margin + (CommonUtil.getScreenWidthAsPixel(activity) - margin) / 2f).toInt()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_NORMAL) {
            var view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_tv_star, parent, false)
            ItemHolder(view)
        } else {
            var view = LayoutInflater.from(parent.ctx)
                .inflate(R.layout.layout_load_more_horizental, parent, false)
            ItemLoadMore(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (models.isNotEmpty()) {
            if (holder is ItemHolder) {
                holder.bind(models[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return models.size
    }

    fun addLoadingView() {
        isLoaderVisible = true
        models.add(UsersModel())
        notifyItemInserted(models.size - 1)
    }

    fun removeLoadingView() {
        isLoaderVisible = false
        val position = models.size - 1
        models.removeAt(position)
        notifyItemRemoved(position)
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

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sdvTvStar: SimpleDraweeView = itemView.findViewById(R.id.sdv_tvStar)
        fun bind(models: UsersModel) {
            with(models) {
                sdvTvStar.setRatio(activity, 1, 1, totalMargin)
                sdvTvStar.setImage(models.avatar?.file_url?.i400)
            }
        }
    }

    inner class ItemLoadMore(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}