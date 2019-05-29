package com.example.dzj.android_practice.viewdemo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.dzj.android_practice.R
import com.example.dzj.android_practice.kotlindemo.dpToPx


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

    constructor(context: Context, attributeSet: AttributeSet) : this(context) {
        val obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RoundRectLayout)
        round = obtainStyledAttributes.getDimension(R.styleable.RoundRectLayout_round, round)
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
        //dx,dy 成对出现，控制上右下左，四个位置圆角
        val array = floatArrayOf(leftTopRound, leftTopRound, rightTopRound, rightTopRound, rightBottomRound, rightBottomRound, leftBottomRound, leftBottomRound);
        mPath.addRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat()), array, Path.Direction.CW)
        //描边用于演示
        drawStroke(canvas)
        canvas.clipPath(mPath)
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
}