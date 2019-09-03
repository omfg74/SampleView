package ru.omfgdevelop.sampleviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class CustomView: View {

    private var  mRectSquare:Rect?= null
    private var mPaintSquare:Paint?= null
    private val SQUARE_SIZE = 100
    constructor(context: Context):super(context){
        initView(null)
    }
    constructor(context:Context,attrs:AttributeSet) :super(context,attrs) {
        initView(attrs)
    }
    constructor(context: Context,attrs:AttributeSet,defStyleAttr:Int):super(context,attrs,defStyleAttr){

    }
    fun initView(set:AttributeSet?){
        mRectSquare = Rect()
        mPaintSquare = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
       super.onDraw(canvas)
//        canvas?.drawColor(Color.RED)

        mRectSquare.left = 10
        mRectSquare.top = 10
        mRectSquare.right = mRectSquare.left +SQUARE_SIZE
        mRectSquare.bottom = mRectSquare.top+SQUARE_SIZE
        mRectSquare.mRectSquare = Color.GREEN
        canvas?.drawRect(mRectSquare,mPaintSquare)
    }
}