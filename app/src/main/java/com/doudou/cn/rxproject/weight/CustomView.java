package com.doudou.cn.rxproject.weight;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.doudou.cn.rxproject.R;

/**
 * Created by jinliang on 16-4-8.
 */
public class CustomView extends View {
     private final static String TAG = CustomView.class.getName();
    private Drawable leftDrawable ;
    private Drawable rightDrawable;
    public CustomView(Context context) {
        super(context);
        initDrawable();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDrawable();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDrawable();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Log.i(TAG, "onLayout: ");
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw: ");
        // 将图片画画到canvas 上面

        leftDrawable.draw(canvas);
    }


    private void initDrawable(){
        leftDrawable = getContext().getDrawable(R.mipmap.burning_active_more_9);
    }
}
