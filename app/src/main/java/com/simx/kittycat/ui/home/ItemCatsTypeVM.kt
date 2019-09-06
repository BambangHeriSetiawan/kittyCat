package com.simx.kittycat.ui.home

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

import com.simx.kittycat.data.model.CatTypes

/**
 * Created by simx on 06,September,2019
 */
class ItemCatsTypeVM(data: CatTypes):BaseObservable() {
    @Bindable var name = ObservableField(data.name)

    @Bindable var image = ObservableField(data.image)

}