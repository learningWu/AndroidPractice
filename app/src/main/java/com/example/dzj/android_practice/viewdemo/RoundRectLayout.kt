package com.example.dzj.android_practice.viewdemo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.dzj.android_practice.kotlindemo.dpToPx


class RoundRectLayout(context: Context, attributeSet: AttributeSet? = null) : FrameLayout(context, attributeSet) {
    /**
     * 开启描边，便于演示效果
     */
    private val mOpenStroke = false
    private val mPath = Path()
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    /**
     * 左上角 圆角大小
     */
    private var leftTopRound: Float
    /**
     * 右上角 圆角大小
     */
    private var rightTopRound: Float
    /**
     * 右下角 圆角大小
     */
    private var leftBottomRound: Float
    /**
     * 左下角 圆角大小
     */
    private var rightBottomRound: Float

    init {
        leftTopRound = dpToPx(20)
        rightTopRound = dpToPx(20)
        leftBottomRound = dpToPx(20)
        rightBottomRound = dpToPx(20)
    }

    override fun dispatchDraw(canvas: Canvas) {

        val round = dpToPx(20)
        //dx,dy 成对出现，控制上右下左，四个位置圆角
        val array = floatArrayOf(round, round, round, round, round, round, round, round);
        mPath.addRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat()), array, Path.Direction.CW)
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
            mPaint.strokeWidth = dpToPx(3)
            canvas.drawPath(mPath, mPaint)
        }
    }
}