package com.doudou.cn.rxproject;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jinliang on 16-4-6.
 */
public class CustomView extends View {
    private Paint mPaint;

    public CustomView(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setShadowLayer(8, 0, 1.05f, 0x80000000);
//        mPaint.setStrokeCapkeWidth(strokeWidth);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }
}
