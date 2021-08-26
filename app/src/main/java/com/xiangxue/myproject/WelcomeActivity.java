package com.xiangxue.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {
    protected ImageView welcome_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcome_iv =  findViewById(R.id.welcome_iv);

        //main线程阻塞会报错
        //必须开启子线程（等待几秒钟）
        //停顿5S钟，在跳转--》Main
        //1、sleep() 2、handler发送延迟消息 3、Time类 4、用动画 0.7-1.0
        ObjectAnimator animator = ObjectAnimator.ofFloat(welcome_iv, "alpha", 0.7f, 1.0f);
        animator.setDuration(5000);
        animator.start();
        //监听，动画什么时候完成，等动画执行完毕需要调到主页面，添加动画执行监听
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}