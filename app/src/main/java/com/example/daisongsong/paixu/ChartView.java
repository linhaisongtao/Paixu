package com.example.daisongsong.paixu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by daisongsong on 2015/8/27.
 */
public class ChartView extends View {
    private int[] data = new int[0];
    private int mMin;
    private int mMax;


    public ChartView(Context context) {
        super(context);
    }

    public ChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (data.length == 0) {
            return;
        }

        computeMaxAndMin();
        double heightPerUnit = 1.0 * getHeight() / mMax;
        int widthPerCell = getWidth() / data.length;


        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        int height = getHeight();
        for (int i = 0; i < data.length; ++i) {
            int t = (int) (heightPerUnit * data[i]);
            int l = widthPerCell * i;
            Rect rect = new Rect(l, height - t, l + widthPerCell - 2, height);
            Log.d(getClass().getSimpleName(), "rect=" + rect);
            canvas.drawRect(rect, paint);
        }
        Log.d(getClass().getSimpleName(), "onDraw heightPerUnit=" + heightPerUnit + ",widthPerCell=" + widthPerCell +
                ",width=" + getWidth() + ",height=" + getHeight());
        canvas.drawText("Test", 10, 20, paint);
    }

    private void computeMaxAndMin() {
        mMin = data[0];
        mMax = data[0];
        for (int i = 1; i < data.length; ++i) {
            if (mMax < data[i]) {
                mMax = data[i];
            }
            if (mMin > data[i]) {
                mMin = data[i];
            }
        }
        Log.d(getClass().getSimpleName(), "min=" + mMin + ",max=" + mMax);
    }


    public void postDraw(int[] data) {
        if (data != null) {
            this.data = data;
        }
        postInvalidate();
    }
}
