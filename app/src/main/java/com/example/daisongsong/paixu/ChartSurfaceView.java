package com.example.daisongsong.paixu;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by daisongsong on 2015/8/27.
 */
public class ChartSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    public ChartSurfaceView(Context context) {
        super(context);
    }

    public ChartSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChartSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
