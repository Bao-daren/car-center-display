package com.example.viewpager2.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.Constans
import com.example.viewpager2.ControlAdapter
import com.example.viewpager2.R
import com.example.viewpager2.bean.ControlBean

class ControlFragment() : Fragment() {

    private val TAG = "ControlFragment"

    lateinit var root: View

    lateinit var commonView : RecyclerView
    lateinit var carView : RecyclerView

    val commonDataList : List<ControlBean> by lazy {
        listOf(
            ControlBean("WIFI" ,R.mipmap.ic_launcher,  Constans.CONTROL_FNUCTION_CODE_WIFI),
            ControlBean("音量" ,R.mipmap.ic_launcher,  Constans.CONTROL_FNUCTION_CODE_VOLUME)
        )
    }

    val carDataList : List<ControlBean> by lazy {
        listOf(
            ControlBean("主驾座椅加热" ,R.mipmap.ic_launcher,  Constans.CONTROL_FNUCTION_CODE_MAIN_SEAT_HEATING),
            ControlBean("副驾座椅加热" ,R.mipmap.ic_launcher,  Constans.CONTROL_FNUCTION_CODE_PASSENGER_SEAT_HEATING)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_control, container, false)
        initView()
        return root
    }

    fun initView(){
        commonView = root.findViewById(R.id.recyclerview_common)
        carView = root.findViewById(R.id.recyclerview_car)

        commonView.layoutManager = GridLayoutManager(requireContext() , 2)
        carView.layoutManager = GridLayoutManager(requireContext() , 2)

        commonView.adapter = ControlAdapter(commonDataList)
        carView.adapter = ControlAdapter(carDataList)
    }



}

