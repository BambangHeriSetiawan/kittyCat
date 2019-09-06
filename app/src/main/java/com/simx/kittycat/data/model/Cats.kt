package com.simx.kittycat.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by simx on 06,September,2019
 */
@Parcelize
class Cats (
    var name:String? = null,
    var image:String? = null
) : Parcelable