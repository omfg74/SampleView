package ru.omfgdevelop.sampleviews

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.Animation
import androidx.annotation.RequiresApi

val circle2 = Path()
var circleWidth = 150f;
val circlePaint = Paint()

class CustomCircle : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun startAnimation(animation: Animation?) {
//        super.startAnimation(animation)
        val valueAnimator: ValueAnimator = ValueAnimator.ofFloat(circleWidth, 1000f)
        valueAnimator.setDuration(1000)
        valueAnimator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            circleWidth = value
            Log.d("Width", "" + circleWidth)
            invalidate()
        }
        valueAnimator.start()

    }

//    fun startAnimation() {
////        super.startAnimation(animation)
//        val valueAnimator: ValueAnimator = ValueAnimator.ofFloat(circleWidth, 1000f)
//        valueAnimator.setDuration(1000)
//        valueAnimator.addUpdateListener { valueAnimator ->
//            val value = valueAnimator.animatedValue as Float
//            circleWidth = value
//            Log.d("Width", "" + circleWidth)
//        }
//        valueAnimator.start()
//        invalidate()
//    }

    override fun onAnimationStart() {
        super.onAnimationStart()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(250f,250f,circleWidth,circlePaint)
    }
}