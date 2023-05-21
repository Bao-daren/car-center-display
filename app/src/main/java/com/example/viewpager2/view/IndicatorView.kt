package com.example.viewpager2.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 *  create by BHB on 5/21/23
 */
class IndicatorView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    // 指示器之间的间距
    private var mIndicatorItemDistance = dp2px(12f)
    //选中与未选中的颜色
    private var mColorSelected = Color.GRAY
    private var mColorUnSelected = Color.WHITE

    // 圆点半径大小  未选中
    private var unSelectCircleRadius = dp2px(4f)
    // 长条宽度
    private var selectWidth = dp2px(40f)

    //画笔
    private var mUnSelectedPaint: Paint? = null
    private var mSelectedPaint: Paint? = null
    //指示器item的区域
    private var mIndicatorItemRectF: RectF? = null


    //指示器item个数
    var mIndicatorItemCount = 0
    //当前选中的位置
    var mCurrentSeletedPosition = 0



    /// 控件宽高 需要计算
    var mIndicatorItemWidth  = 0
    var mIndicatorItemHeight = unSelectCircleRadius * 2

    init {
        mUnSelectedPaint = Paint().apply {
            style = Paint.Style.FILL
            isAntiAlias = true
            color = Color.GRAY
        }
        mSelectedPaint = Paint().apply {
            style = Paint.Style.FILL
            isAntiAlias = true
            color = Color.WHITE
        }
        mIndicatorItemRectF = RectF()
    }

    // 核心逻辑，计算布局尺寸
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val heightSize: Int = MeasureSpec.getSize(heightMeasureSpec)
        // 整体宽度
        mIndicatorItemWidth =  selectWidth + (mIndicatorItemCount - 1) * (mIndicatorItemDistance + unSelectCircleRadius) + 20
        // 整体高度
        setMeasuredDimension(mIndicatorItemWidth, mIndicatorItemHeight)
    }


    var currentWidth =5f
    // 核心逻辑，计算绘制内容
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if(0 == mCurrentSeletedPosition){
            currentWidth =5f
        }else{
            currentWidth = unSelectCircleRadius.toFloat()/2 + 5f
        }
        for (i in 0 until mIndicatorItemCount){
            if(i == mCurrentSeletedPosition){
                canvas.drawRoundRect( currentWidth, 0f , currentWidth + selectWidth.toFloat() , measuredHeight.toFloat() , 10f , 10f , mSelectedPaint!!)
                currentWidth += mIndicatorItemDistance + selectWidth

            }else{
                canvas.drawCircle( currentWidth, measuredHeight/2f  , unSelectCircleRadius.toFloat() , mUnSelectedPaint!!)
                currentWidth += mIndicatorItemDistance + unSelectCircleRadius
            }
        }



//        val cy = mIndicatorItemHeight.div(2f)
//        for (i in 0 until mIndicatorItemCount) {
//            val cx = i * dp2px(40f).toFloat() + i * mIndicatorItemDistance
//            (if (i == mCurrentSeletedPosition) mSelectedPaint else mUnSelectedPaint)?.let {
//                canvas.drawRect(cx, cy - 1f, cx + 40f, cy + 1f,
//                    it
//                )
//            }
//        }
    }

    private fun dp2px(dpValue: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}
