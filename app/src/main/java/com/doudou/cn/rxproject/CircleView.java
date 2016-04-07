package com.doudou.cn.rxproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jinliang on 16-4-5.
 */
public class CircleView extends View {
    private Paint paint ;
  float width = 300 ;
    float start = 0 ;
    float end  =300 ;
    public CircleView(Context context) {
        super(context);
        initPaint();
    }



    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        :context.arc(canvas.width/2,canvas.height/2,100,0,Math.PI*2,true);




    }

    private void initPaint() {
        paint = new Paint() ;
        paint.setColor(getContext().getResources().getColor(R.color.colorAccent));


    }
}
