package com.example.dzj.android_practice.viewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.example.dzj.android_practice.R;


/**
 * Created by think on 17/7/12.
 */

public class RoundAngleImageView extends AppCompatImageView {

    private Paint paint;

    //4个方向的半径
    private int round = 20;

    // 左上 左下 右上 右下
    private int roundLeftUp = 0;
    private int roundLeftDown = 0;
    private int roundRightUp = 0;
    private int roundRightDown = 0;

    private Paint paint2;

    public RoundAngleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public RoundAngleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RoundAngleImageView(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundAngleImageView);
            round = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_round, 0);
            roundLeftUp = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_roundLeftUp, roundLeftUp);
            roundLeftDown = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_roundLeftDown, roundLeftDown);
            roundRightUp = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_roundRightUp, roundRightUp);
            roundRightDown = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_roundRightDown, roundRightDown);
            a.recycle();
        } else {
            float density = context.getResources().getDisplayMetrics().density;
            round = (int) (round * density);
        }

        if (round != 0) {
            roundLeftUp = roundLeftDown = roundRightUp = roundRightDown = round;
        }

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

        paint2 = new Paint();
        paint2.setXfermode(null);
    }

    @Override
    public void draw(Canvas canvas) {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError outOfMemoryError) {
            bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
        } finally {
            if (bitmap == null) {
                return;
            }
            Canvas canvas2 = new Canvas(bitmap);
            super.draw(canvas2);
            drawLiftUp(canvas2);
            drawLiftDown(canvas2);
            drawRightUp(canvas2);
            drawRightDown(canvas2);
//            canvas.drawBitmap(bitmap, 0, 0, paint2);
            bitmap.recycle();
        }
    }

    private void drawLiftUp(Canvas canvas) {
        if (roundLeftUp == 0)
            return;
        Path path = new Path();
        path.moveTo(0, roundLeftUp);
        path.lineTo(0, 0);
        path.lineTo(roundLeftUp, 0);
        path.arcTo(new RectF(0, 0, roundLeftUp * 2, roundLeftUp * 2), -90, -90);
        path.close();
        canvas.drawPath(path, paint);
    }

    private void drawLiftDown(Canvas canvas) {
        if (roundLeftDown == 0)
            return;
        Path path = new Path();
        path.moveTo(0, getHeight() - roundLeftDown);
        path.lineTo(0, getHeight());
        path.lineTo(roundLeftDown, getHeight());
        path.arcTo(new RectF(0, getHeight() - roundLeftDown * 2, roundLeftDown * 2, getHeight()), 90, 90);
        path.close();
        canvas.drawPath(path, paint);
    }

    private void drawRightDown(Canvas canvas) {
        if (roundRightDown == 0)
            return;
        Path path = new Path();
        path.moveTo(getWidth() - roundRightDown, getHeight());
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth(), getHeight() - roundRightDown);
        path.arcTo(new RectF(getWidth() - roundRightDown * 2, getHeight() - roundRightDown * 2, getWidth(), getHeight()), -0, 90);
        path.close();
        canvas.drawPath(path, paint);
    }

    private void drawRightUp(Canvas canvas) {
        if (roundRightUp == 0)
            return;
        Path path = new Path();
        path.moveTo(getWidth(), roundRightUp);
        path.lineTo(getWidth(), 0);
        path.lineTo(getWidth() - roundRightUp, 0);
        path.arcTo(new RectF(getWidth() - roundRightUp * 2, 0, getWidth(), roundRightUp * 2), -90, 90);
        path.close();
        canvas.drawPath(path, paint);
    }
}
