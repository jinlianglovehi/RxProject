package com.doudou.cn.rxproject;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity   {
    private final static String TAG = MainActivity.class.getName();
    @Bind(R.id.btn_test)
    TextView btnTest;
    @Bind(R.id.content)
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_test)
    public void btnClick() {

        final ValueAnimator animator = ValueAnimator.ofInt(1, 100);
        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());//线性效果变化
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer integer = (Integer) animator.getAnimatedValue();
                Log.i(TAG, "onAnimationUpdate:进行中");
                content.setText("AnimatedValue:" + integer  + "--- playTime:"+ animator.getCurrentPlayTime());
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

                //动画的开始
                Log.i(TAG, "onAnimationStart: --------------onAnimationStart-------------");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // 动画的结束
                Log.i(TAG, "onAnimationEnd: --------------onAnimationEnd-------------");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.i(TAG, "onAnimationCancel: --------------onAnimationCancel-------------");

                Log.i(TAG, "onAnimationCancel: 动画的取消");
            }


            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i(TAG, "onAnimationRepeat: ---------------onAnimationRepeat-----------------");
// 动画的重复
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            animator.addPauseListener(new Animator.AnimatorPauseListener() {
                @Override
                public void onAnimationPause(Animator animation) {
                    Log.i(TAG, "onAnimationPause: ********************************");

                }

                @Override
                public void onAnimationResume(Animator animation) {
                    Log.i(TAG, "onAnimationResume: ********************************");

                }
            });
        }
//        animator.start();



    }

    private float startX = 0 ,startY = 0,endX ,endY;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: 进入分发函数入口");
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                Log.i(TAG, "dispatchTouchEvent: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                endX = ev.getX();
                endY = ev.getY();
                Log.i(TAG, "dispatchTouchEvent: ACTION_MOVE" + "--x 滑动距离："+(endX-startX) + "---Y 滑动距离："+(endY - startY));
                break;
            case MotionEvent.ACTION_UP:
                endX = ev.getX();
                endY = ev.getY();
                Log.i(TAG, "dispatchTouchEvent: ACTION_UP" + "--x 滑动距离："+(endX-startX) + "---Y 滑动距离："+(endY -startY));
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


}
