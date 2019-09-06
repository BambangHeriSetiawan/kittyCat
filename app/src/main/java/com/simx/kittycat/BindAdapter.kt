package com.simx.kittycat

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.Coil
import coil.api.load
import coil.transform.RoundedCornersTransformation


/**
 * Created by simx on 06,September,2019
 */
class BindAdapter {
    companion object {
        @BindingAdapter("bind:image_asset") @JvmStatic fun loadIntImage(imageView: ImageView, url:Int){
            imageView.load(url){
                placeholder(R.drawable.placeholder)
                transformations(RoundedCornersTransformation(2f))
            }
        }
        @BindingAdapter("bind:image_url") @JvmStatic fun loadImage(imageView: ImageView, url:String?){
            Coil.load(imageView.context, url){ target { draw -> run {
                imageView.setImageDrawable(draw)
                error(R.drawable.placeholder)
                transformations(RoundedCornersTransformation(1f))
            }}}
        }
        @BindingAdapter("bind:visibility") @JvmStatic fun setVisibility(view: View, value: Boolean) {
            view.visibility = if (value) View.VISIBLE else View.GONE
        }


    }
}