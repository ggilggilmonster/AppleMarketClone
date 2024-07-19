package com.example.applemarketclone

import android.os.Parcelable

@Parcelize
data class MyItem(
    val image: Int,
    var title: String,
    val address: String,
    val price: String,
    val seller: String,
    val postDetail: String,
    val replies: Int,
    val likes: Int,
) : Parcelable {
}