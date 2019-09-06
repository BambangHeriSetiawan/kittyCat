package com.simx.kittycat.ui.home

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simx.kittycat.data.SampleData
import com.simx.kittycat.data.model.CatTypes

class HomeVM : BaseObservable() {
    @Bindable var catTypes = MutableLiveData<List<CatTypes>>()

    fun getCatTypes(){
        catTypes.postValue(SampleData.sampleDataCats())
    }
}