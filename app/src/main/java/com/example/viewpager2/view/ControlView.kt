package com.example.viewpager2.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.R

/**
 *  负一屏view
 *
 */
class ControlView : LinearLayout {


    lateinit var  root  : View
    lateinit var commonView : RecyclerView
    lateinit var carView : RecyclerView


    @JvmOverloads
    constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0 ) : super(
        context,
        attrs,
        defStyleAttr
    ){
        init(context)
    }

    fun init(context: Context?){

        Log.e("ControlView", "init: ", )
        root = LayoutInflater.from(context).inflate(R.layout.fragment_control , this , true)
        initView()

    }


    fun initView(){
        commonView = rootView.findViewById(R.id.recyclerview_common)
        carView = rootView.findViewById(R.id.recyclerview_car)
    }
}