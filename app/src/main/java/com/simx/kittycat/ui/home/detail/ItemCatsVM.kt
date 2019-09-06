package com.simx.kittycat.ui.home.detail

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import com.simx.kittycat.data.model.Cats

/**
 * Created by simx on 06,September,2019
 */
class ItemCatsVM(data:Cats):BaseObservable() {

    @Bindable var name = ObservableField(data.name)

    @Bindable var image = ObservableField(data.image)
}