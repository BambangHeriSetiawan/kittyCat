package com.simx.kittycat.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by simx on 06,September,2019
 */
@Parcelize
class CatTypes(
    var name:String? = null,
    var image:String? = null,
    var types:DataCats? = null

    ) : Parcelable {
    @Parcelize
    data class DataCats (
        var data:List<Cats>
    ) : Parcelable
}