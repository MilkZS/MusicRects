package com.milkzs.android.music;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MusicView extends View {

    private String TAG = "MusicView";
    private boolean DBG = false;

    private int viewWidth = 1000;
    private int viewHeight = 400;
    private int count = 10;
    private int rectHeight = viewHeight - 100;
    private int rectWidth = 50;
    private int rectSpace = 3;

    private Paint paint = new Paint();
    private Random random  = new Random();

    public MusicView(Context context) {
        super(context);
    }

    public MusicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, viewHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        for(int i=0;i<count;i++){
            int y = random.nextInt(rectHeight) + 30;
            int x = i*rectSpace + i*rectWidth;
            Log.d(TAG,"y is " + y);
            canvas.drawRect(x,y,x+rectWidth,viewHeight,paint);
            y = y - 10;
            paint.setStrokeWidth(5);
            canvas.drawLine(x,y,x+rectWidth,y,paint);
        }

        postInvalidateDelayed(400);
    }
}