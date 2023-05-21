package com.example.viewpager2.bean

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 *  负一屏item bean
 */
data class ControlBean(
    var name : String,
    var imgRes : Int ,
    var functionCode : Int,
    var enable : Boolean = false


)