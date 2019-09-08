package ru.omfgdevelop.sampleviews


import android.R.attr.*
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Looper
import android.os.Handler;
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.animation.Animation
import kotlin.math.roundToInt
import android.R.attr.animation
import androidx.core.view.ViewCompat.setTranslationX
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class CustomView : View {

    private var mRectSquare: RectF = RectF()
    private var mPaintSquare: Paint = Paint()
    private var mDrawText: String = String()
    private var mTextColor: Paint = Paint()
    private val START_ANGLE_POINT = 90

    val path = Path()
    val strokeWidth: Float = 40f
    val circle = RectF(strokeWidth, strokeWidth, 200 + strokeWidth, 200 + strokeWidth)
    val circle2 = Path()
    var circleWidth = 150f;
    val circlePaint = Paint()
    val angle = 120f
    var bitmap: Bitmap? = null
    val scale = getContext().getResources().getDisplayMetrics().scaledDensity;
    val dns = getContext().getResources().getDisplayMetrics().density;


    private val SQUARE_START_SIZE = 10f
    private val SQUARE_SIZE = 200f

    constructor(context: Context) : super(context) {
        initView(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(attrs)
    }

    fun initView(set: AttributeSet?) {


        val typedArray: TypedArray =
            context.theme.obtainStyledAttributes(set, R.styleable.CustomView, 0, 0)
        try {
            mPaintSquare.color = typedArray.getColor(R.styleable.CustomView_setColor, Color.WHITE)
            mDrawText = typedArray.getString(R.styleable.CustomView_text) ?: ""
            mTextColor.color = typedArray.getColor(R.styleable.CustomView_TextColor, Color.WHITE)
            circlePaint.isAntiAlias = true
            circlePaint.style = Paint.Style.STROKE
            circlePaint.strokeWidth = strokeWidth
            circlePaint.color = Color.GREEN
        } finally {
            typedArray.recycle()
        }


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mRectSquare.left = SQUARE_START_SIZE
        mRectSquare.top = SQUARE_START_SIZE
        mRectSquare.right = mRectSquare.left + SQUARE_SIZE
        mRectSquare.bottom = mRectSquare.top + SQUARE_SIZE
        mTextColor.textSize = 20f
//            mTextColor.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
        canvas?.drawRect(mRectSquare, mPaintSquare)
        canvas?.drawText(mDrawText, SQUARE_START_SIZE, SQUARE_START_SIZE + 20f, mTextColor)



        path.addCircle(width.toFloat() / 2, height.toFloat() / 2, 100f, Path.Direction.CW)
        val paint = Paint()
        paint.color = mTextColor.color
        paint.textSize = 20f*scale
        canvas?.drawTextOnPath(mDrawText, path, 0f, 0f, paint)


        canvas?.drawArc(circle, START_ANGLE_POINT.toFloat(), angle, false, circlePaint)
        if (bitmap != null) {
            canvas?.drawBitmap(
                bitmap,
                SQUARE_START_SIZE.toFloat(),
                SQUARE_START_SIZE.toFloat(),
                null
            )
        }


//        circle2.addCircle(250,250,circleWidth,Path.Direction.CW)


    }

    override fun startAnimation(animation: Animation?) {
        super.startAnimation(animation)


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val gestureDetector = GestureDetector(context, object : GestureDetector.OnGestureListener {
            override fun onShowPress(p0: MotionEvent?) {

            }

            override fun onSingleTapUp(p0: MotionEvent?): Boolean {
                return false
            }

            override fun onDown(p0: MotionEvent?): Boolean {
                return false
            }

            override fun onFling(
                p0: MotionEvent?,
                p1: MotionEvent?,
                p2: Float,
                p3: Float
            ): Boolean {
                return false
            }

            override fun onScroll(
                p0: MotionEvent?,
                p1: MotionEvent?,
                p2: Float,
                p3: Float
            ): Boolean {
                return false
            }

            override fun onLongPress(p0: MotionEvent?) {

            }
        })
        return gestureDetector.onTouchEvent(event)
    }
}