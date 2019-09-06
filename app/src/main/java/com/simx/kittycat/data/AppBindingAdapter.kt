package com.simx.kittycat.data

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.RoundedCornersTransformation


/**
 * Created by simx on 06,September,2019
 */
class AppBindingAdapter {
    companion object {
        @BindingAdapter("bind:image_asset") @JvmStatic fun loadIntImage(imageView: ImageView, url:Int){
            imageView.load(url){
                crossfade(true)
                transformations(RoundedCornersTransformation(2f))
            }
        }
        @BindingAdapter("bind:visibility") @JvmStatic fun setVisibility(view: View, value: Boolean) {
            view.visibility = if (value) View.VISIBLE else View.GONE
        }


    }
}