package com.eddie.viewdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode


class LoadingView : View {

    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var radius = 0f

    constructor(context: Context?) : super(context) {
    }

    constructor(context: Context?, attributeSet: AttributeSet) : super(context, attributeSet) {
    }

    init {
        paint.also {
            it.color = Color.BLUE
            it.style = Paint.Style.STROKE

        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        radius = w / 2f
    }

    val wave = Path()
    override fun onDraw(canvas: Canvas) {

        // 外轮廓
        canvas.drawCircle(measuredWidth / 2f, measuredHeight / 2f, measuredWidth / 2f, this.paint)

        //波浪线
        wave.moveTo(0f, radius)
        wave.quadTo(radius + deltaX, measuredHeight.toFloat() + deltaY, measuredWidth.toFloat(), radius)
        canvas.drawPath(wave, this.paint)
    }

    var downX = 0f
    var downY = 0f
    var deltaX = 0f
    var deltaY = 0f
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                downY = event.y
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                deltaX = event.x - downX
                deltaY = event.y - downY
                invalidate()
                return true
            }
        }

        return false
    }
}