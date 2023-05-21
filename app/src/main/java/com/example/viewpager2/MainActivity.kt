package com.example.viewpager2

import android.icu.lang.UCharacter.IndicPositionalCategory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.viewpager2.fragment.ControlFragment
import com.example.viewpager2.fragment.PageFragment
import com.example.viewpager2.view.ControlView
import com.example.viewpager2.view.IndicatorView


class MainActivity : AppCompatActivity () {


    private val TAG ="MainActivity"

    lateinit var viewPager : ViewPager2
    lateinit var indicator : IndicatorView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        indicator = findViewById(R.id.indicator)

        viewPager.registerOnPageChangeCallback(object: OnPageChangeCallback(){


            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator.visibility =  if (position == 0 ) View.GONE else View.VISIBLE
                indicator.mCurrentSeletedPosition = position -1
                indicator.postInvalidate()

            }
        })

        var fragmentList = listOf<Fragment>(
            ControlFragment(),
            PageFragment(
                listOf(
                    TextView(this).apply {
                        text = "addview2"
                    },
                    TextView(this).apply {
                        text = "addview2"
                    },
                    TextView(this).apply {
                        text = "addview2"
                    }
                )
            ),

            PageFragment(
                listOf(
                    TextView(this).apply {
                        text = "addview3"
                    },
                    TextView(this).apply {
                        text = "addview3"
                    },
                )
            ),
            PageFragment(
                listOf(
                    TextView(this).apply {
                        text = "addview2"
                    },
                    TextView(this).apply {
                        text = "addview2"
                    },
                    TextView(this).apply {
                        text = "addview2"
                    }
                )
            ),

            PageFragment(
                listOf(
                    TextView(this).apply {
                        text = "addview3"
                    },
                    TextView(this).apply {
                        text = "addview3"
                    },
                )
            ),
        )

        indicator.mIndicatorItemCount = fragmentList.size -1


        viewPager.offscreenPageLimit = 3
        viewPager.adapter = HomePageAdapter(this , fragmentList)
        viewPager.setCurrentItem(1 , false)

    }
}
