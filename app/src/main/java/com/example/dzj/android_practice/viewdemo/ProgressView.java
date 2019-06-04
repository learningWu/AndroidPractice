package com.example.dzj.android_practice.viewdemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.eddie.annotationprocessor.CheckGetAnnotation;
@CheckGetAnnotation
public class ProgressView extends View {

    /**
     * 线长
     */
    private int lineLength;
    /**
     * 线间距
     */
    private int lineSpace;
    /**
     * 线宽
     */
    private int lineWidth;
    private PointF centerPoint;
    private TwoPoint[] points = new TwoPoint[5];
    private Paint paint;

    public void getPaint(){}
    private ValueAnimator lengthChangeAnimator;

    {
        centerPoint = new PointF();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#08AEAB"));
        paint.setStrokeCap(Paint.Cap.ROUND);


    }

    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //获得测量后的中心位置
        centerPoint.x = getMeasuredWidth() / 2f;
        centerPoint.y = getMeasuredHeight() / 2f;
        //留点上边距
        lineLength = getMeasuredHeight() - 50;
        //间距是宽度的4倍
        lineWidth = getMeasuredWidth() / 27;
        lineSpace = lineWidth * 4;
        paint.setStrokeWidth(lineWidth);
        if (lengthChangeAnimator == null) {
            lengthChangeAnimator = getLineChangeAnimator();
        }
        if (!lengthChangeAnimator.isRunning()) {
            lengthChangeAnimator.start();
        }
        drawLines(canvas);
    }

    private ValueAnimator getLineChangeAnimator() {
        //通过角度控制 长度 (可以同一个长度初始，不同的矢量方向)
        float[] originAngle = {40, 50, 60, 70, 80};
        //映射的有效值
        //省略了final(内部类中使用局部变量) 编译器会加
        float[] effectLineLength = new float[5];

        //生成动画  以三角函数进行高度变化
        //360为一周期，使每段动画结束后都在起始位置
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 360f);
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            for (int i = 0; i < originAngle.length; i++) {
                float angle = originAngle[i] + value;
                //toRadians转换成 多少 pie
                effectLineLength[i] = (float) (lineLength * Math.abs(Math.sin(Math.toRadians(angle))));
            }
            //计算每一个进度条的起始-终点
            computePoints(effectLineLength);
            invalidate();
        });
        return valueAnimator;
    }

    private void computePoints(float[] lengths) {
        float firstX = centerPoint.x - 2 * lineSpace;
        for (int i = 0; i < lengths.length; i++) {
            TwoPoint point = new TwoPoint();
            point.endPoint.x = point.startPoint.x = firstX + lineSpace * i;
            point.startPoint.y = centerPoint.y - lengths[i] / 2;
            point.endPoint.y = centerPoint.y + lengths[i] / 2;
            points[i] = point;
        }
    }


    private void drawLines(Canvas canvas) {
        for (TwoPoint twoPoint : points) {
            canvas.drawLine(twoPoint.startPoint.x, twoPoint.startPoint.y, twoPoint.endPoint.x, twoPoint.endPoint.y, paint);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void pauseAnimator() {
        if (lengthChangeAnimator != null && lengthChangeAnimator.isRunning()) {
            lengthChangeAnimator.pause();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void resumeAnimator() {
        if (lengthChangeAnimator != null && lengthChangeAnimator.isPaused()) {
            lengthChangeAnimator.resume();
        }
    }


    class TwoPoint {
        PointF startPoint, endPoint;

        TwoPoint() {
            startPoint = new PointF();
            endPoint = new PointF();
        }
    }
}
