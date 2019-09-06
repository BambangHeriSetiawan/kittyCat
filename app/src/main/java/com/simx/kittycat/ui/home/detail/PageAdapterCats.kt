package com.simx.kittycat.ui.home.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.simx.kittycat.R
import com.simx.kittycat.data.model.Cats
import com.simx.kittycat.databinding.ItemCatBinding

/**
 * Created by simx on 07,September,2019
 */
class PageAdapterCats(private var data:List<Cats>): PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var binding = ItemCatBinding.bind(LayoutInflater.from(container.context).inflate(R.layout.item_cat, container, false))
        with(binding){
            itemCatVm = ItemCatsVM(data[position])
            executePendingBindings()
        }
        container.addView(binding.root)
        return binding.root
    }
    /**
     * Determines whether a page View is associated with a specific key object
     * as returned by [.instantiateItem]. This method is
     * required for a PagerAdapter to function properly.
     *
     * @param view Page View to check for association with `object`
     * @param object Object to check for association with `view`
     * @return true if `view` is associated with the key object `object`
     */
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    /**
     * Return the number of views available.
     */
    override fun getCount(): Int {
        return data.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}