package com.example.insbaykotlin.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.example.insbaykotlin.R
import com.example.insbaykotlin.common.ext.setImage
import com.example.insbaykotlin.data.model.ImageModel
import com.facebook.drawee.view.SimpleDraweeView

class ImageFeedAdapter(
    var models: ArrayList<ImageModel>,
    var activity: AppCompatActivity,
    var itemClickListener: (ImageModel) -> Unit
) : PagerAdapter() {
    override fun getCount(): Int {
        return models.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view =
            LayoutInflater.from(activity).inflate(R.layout.item_image_k_feed, container, false)
        bind(view, models[position])
        container.addView(view)
        return view
    }

    private fun bind(view: View, model: ImageModel) {
        var sdvImage: SimpleDraweeView = view.findViewById(R.id.sdv_image)
        sdvImage.setImage(model.file_url.i400)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        return container.removeView(`object` as View?)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
}