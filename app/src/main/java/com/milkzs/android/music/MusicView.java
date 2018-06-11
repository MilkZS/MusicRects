package com.milkzs.android.music;

import android.content.Context;
import android.content.res.TypedArray;
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

    /** The length and width of the custom view display interface   */
    private int viewWidth = 1000;
    private int viewHeight = 400;

    /** counts ot rect shows */
    private int count = 10;

    /** height band for random number */
    private int rectHeight = viewHeight - 100;

    /** Width of rect */
    private int rectWidth = 50;

    /** Internal of two Rect */
    private int rectSpace = 3;

    /** frequency of refresh  */
    private int frequency = 300;

    /** color of Rect */
    private int color_paint = Color.GREEN;

    private int leftSpace = 3;

    private Paint paint = new Paint();
    private Random random  = new Random();

    public MusicView(Context context) {
        super(context);
    }

    public MusicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MusicView);

        for(int i=0;i<ta.length();i++){
            switch (ta.getIndex(i)){
                case R.styleable.MusicView_width_rect:{
                    rectWidth = ta.getInt(ta.getIndex(i),rectWidth);
                }break;
                case R.styleable.MusicView_height_rect:{
                    rectHeight = ta.getInt(ta.getIndex(i),rectHeight);
                }break;
                case R.styleable.MusicView_color_rect:{
                    color_paint = ta.getInt(ta.getIndex(i),color_paint);
                }break;
                case R.styleable.MusicView_frequency_rect:{
                    frequency = ta.getInt(ta.getIndex(i),frequency);
                }break;
                case R.styleable.MusicView_count_rect:{
                    count = ta.getInt(ta.getIndex(i),count);
                }break;
            }
        }

        paint.setColor(color_paint);
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
            int x = i*rectSpace + i*rectWidth + 3;
            if (DBG)Log.d(TAG,"y is " + y);
            canvas.drawRect(x,y,x+rectWidth,viewHeight,paint);
            y = y - 10;
            paint.setStrokeWidth(5);
            canvas.drawLine(x,y,x+rectWidth,y,paint);
        }

        postInvalidateDelayed(frequency);
    }
}
