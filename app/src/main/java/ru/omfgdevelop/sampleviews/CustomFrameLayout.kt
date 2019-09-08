package ru.omfgdevelop.sampleviews

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout


class CustomFrameLayout: FrameLayout {
    constructor(context: Context) : super(context){

    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)



    init{

        val layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val layoutParams2 = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val layoutParams3 = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val customCircle = CustomCircle(context)
        val scale = getContext().getResources().getDisplayMetrics().density;

        layoutParams.leftMargin = 20*scale.toInt()
        layoutParams2.rightMargin = 20*scale.toInt()
        layoutParams3.topMargin = 150*scale.toInt()
        layoutParams2.gravity = Gravity.RIGHT
        layoutParams3.gravity = Gravity.CENTER_HORIZONTAL

        circle2
        addView(customCircle)
        customCircle.startAnimation(null)
         val circle = Circle(context)
         val circle2 = Circle(context)
         val circle3 = Circle(context)
        addView(circle,layoutParams)
//        addView(circle2,layoutParams2)
//        addView(circle3,layoutParams3)
        val animation = CircleAngleAnimation(circle, 360)
        val animation2 = CircleAngleAnimation(circle2, 360)
        val animation3 = CircleAngleAnimation(circle3, 180)
        animation.duration = 1000
        animation2.duration = 1000
        animation3.duration = 1000
        circle.startAnimation(animation)
        circle2.startAnimation(animation2)
        circle3.startAnimation(animation3)
    }
}