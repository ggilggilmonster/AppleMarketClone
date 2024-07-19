package com.example.applemarketclone

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyItem(val image: Int, var title: String, val address: String, val price: Int, val seller: String, val postDetail: String, val replies: Int, val likes: Int, ) : Parcelable