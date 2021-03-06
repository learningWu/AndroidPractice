package com.example.dzj.android_practice.viewdemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.dzj.android_practice.R
import com.example.dzj.android_practice.util.dpToPx


class RoundRectLayout(context: Context) : FrameLayout(context) {


    /**
     * 开启描边，便于演示效果
     */
    private val mOpenStroke = false
    private val mPath = Path()
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    /**
     * 左上角 圆角大小
     */
    private var leftTopRound: Float = 0f
    /**
     * 右上角 圆角大小
     */
    private var rightTopRound: Float = 0f
    /**
     * 右下角 圆角大小
     */
    private var leftBottomRound: Float = 0f
    /**
     * 左下角 圆角大小
     */
    private var rightBottomRound: Float = 0f

    /**
     * 全部圆角
     */
    private var round: Float = 0f

    @SuppressLint("ResourceType")
    constructor(context: Context, attributeSet: AttributeSet) : this(context) {
        val obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RoundRectLayout)
        round = obtainStyledAttributes.getDimension(R.styleable.RoundRectLayout_round, round)
        leftTopRound = obtainStyledAttributes.getDimension(R.styleable.RoundRectLayout_leftTopRound, leftTopRound)

        //第二种获取属性值的方法,(styleable的原理)
//        val obtainStyledAttributesWithAttrArray = getContext().obtainStyledAttributes(attributeSet, intArrayOf(R.attr.round,R.attr.leftTopRound,android.R.attr.id))
//        round = obtainStyledAttributesWithAttrArray.getDimension(0, round)
//        leftTopRound= obtainStyledAttributesWithAttrArray.getDimension(1, leftTopRound)
//        var id=obtainStyledAttributesWithAttrArray.getInteger(2,0)

        leftTopRound = obtainStyledAttributes.getDimension(R.styleable.RoundRectLayout_leftTopRound, leftTopRound)
        rightTopRound = obtainStyledAttributes.getDimension(R.styleable.RoundRectLayout_rightTopRound, rightTopRound)
        rightBottomRound = obtainStyledAttributes.getDimension(R.styleable.RoundRectLayout_rightBottomRound, rightBottomRound)
        leftBottomRound = obtainStyledAttributes.getDimension(R.styleable.RoundRectLayout_leftBottomRound, leftBottomRound)
        if (round != 0f) {
            //不知道为啥 不能 leftTopRound=rightTopRound=rightBottomRound=leftBottomRound = round
            leftTopRound = round
            rightTopRound = round
            rightBottomRound = round
            leftBottomRound = round
        }
        obtainStyledAttributes.recycle()
    }

    override fun dispatchDraw(canvas: Canvas) {
        //1.
        //dx,dy 成对出现，控制上右下左，四个位置圆角
        val array = floatArrayOf(leftTopRound, leftTopRound, rightTopRound, rightTopRound, rightBottomRound, rightBottomRound, leftBottomRound, leftBottomRound);
        mPath.addRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat()), array, Path.Direction.CW)
        //2.
        //描边用于演示
        drawStroke(canvas)
        //3.
        canvas.clipPath(mPath)
        //4.
        super.dispatchDraw(canvas)
    }

    /**
     * 描边
     */
    fun drawStroke(canvas: Canvas) {
        if (mOpenStroke) {
            mPaint.color = Color.RED
            mPaint.style = Paint.Style.STROKE
            mPaint.strokeWidth = dpToPx(3f)
            canvas.drawPath(mPath, mPaint)
        }
    }

    /**
     * 避免默认以为子view在滑动控件内，需要有个延迟点击的效果。
     */
    override fun shouldDelayChildPressedState(): Boolean {
        return false
    }
}