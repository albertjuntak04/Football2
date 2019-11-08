package com.example.football

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataClub(val image:Int, val nama:String?, val desc:String?):Parcelable {

}