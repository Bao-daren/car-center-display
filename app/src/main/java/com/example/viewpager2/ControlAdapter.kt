package com.example.viewpager2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.bean.ControlBean
import com.example.viewpager2.databinding.ItemControlBinding

/**
 *  create by BHB on 5/21/23
 */
class ControlAdapter(val dataList: List<ControlBean>) : RecyclerView.Adapter<ControlHold>() {


    private val TAG = "ControlAdapter"

    /// 刷新某一功能的状态
    public fun updateStatus(functionCode : Int , enable : Boolean){
        for (item in dataList) {
            if(item.functionCode == functionCode){
                if(item.enable != enable ){
                    item.enable = enable
                    notifyItemChanged(dataList.indexOf(item))
                }
                break
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ControlHold {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_control , parent , false)
        return ControlHold(itemView)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: ControlHold, position: Int) {
//        holder.binding.controlBean = dataList[position]
        var data = dataList[position]
        holder.binding.image.setImageResource(data.imgRes)
        holder.binding.name.text = data.name
        holder.binding.root.setOnClickListener {
            Log.d(TAG, "onItemClick: ${data.functionCode}")

        }
    }


}

class ControlHold: RecyclerView.ViewHolder {


    var binding : ItemControlBinding

    constructor(itemView : View):super(itemView){
        binding = DataBindingUtil.bind<ItemControlBinding>(itemView)!!

    }

}