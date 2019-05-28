package com.example.dzj.android_practice.viewdemo

import android.content.Context
import android.graphics.*
import android.graphics.BitmapFactory.decodeResource
import android.util.AttributeSet
import android.view.View
import com.example.dzj.android_practice.R
import java.util.jar.Attributes

class XfermodeView(context: Context?, attributeSet: AttributeSet? = null) : View(context, attributeSet) {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val options = BitmapFactory.Options()
    val porterDuff = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    override fun onDraw(canvas: Canvas) {
        val bitmap = decodeResource(resources, R.mipmap.spid)
        val saveLayer = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)
        canvas.drawOval(RectF(0f,0f,bitmap.width.toFloat(),bitmap.height.toFloat()),paint)

        paint.xfermode = porterDuff
        paint.style=Paint.Style.FILL
        paint.color=Color.RED
        canvas.drawBitmap(bitmap, 0f, 0f, paint);

        paint.xfermode = null; // 用完及时清除 Xfermode
        canvas.restoreToCount(saveLayer)

    }
}
