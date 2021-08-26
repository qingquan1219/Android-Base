package com.xiangxue.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.xiangxue.myproject.adapter.HomePagerAdapter;
import com.xiangxue.myproject.fragment.CenterFragment;
import com.xiangxue.myproject.fragment.CollectionFragment;
import com.xiangxue.myproject.fragment.HomeFragment;
import com.xiangxue.myproject.fragment.MessageFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{
    private ViewPager mViewPage;
    private RadioButton mHomeRb, mCollectRb, mMessageRb, mCenterRb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //主页面的解决方案
        //1、ViewPager + Fragment + RadioButton(目前是最好的方式)
        //2、TabHost + Fragment(过时了)
        //3、ViewGroup + Fragment + 动态的去切换，会不断的销毁和创建（性能上不好）
        initView();
        initData();

    }

    private final void initView() {
        mViewPage = (ViewPager) findViewById(R.id.view_pager);

        mHomeRb = (RadioButton)findViewById(R.id.home_rb);
        mCollectRb = (RadioButton)findViewById(R.id.collect_rb);
        mMessageRb = (RadioButton)findViewById(R.id.message_rb);
        mCenterRb = (RadioButton)findViewById(R.id.center_rb);

        mHomeRb.setOnClickListener(this);
        mCollectRb.setOnClickListener(this);
        mMessageRb.setOnClickListener(this);
        mCenterRb.setOnClickListener(this);

        mViewPage.setOnPageChangeListener(this);
    }

    private final void initData() {
        //给ViewPage设置Adapter

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CollectionFragment());
        fragments.add(new MessageFragment());
        fragments.add(new CenterFragment());

        //适配器
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), fragments);

        //适配器交给ViewPager
        mViewPage.setAdapter(homePagerAdapter);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_rb:
                mViewPage.setCurrentItem(0, false);
                break;
            case R.id.collect_rb:
                mViewPage.setCurrentItem(1, false);
                break;
            case R.id.message_rb:
                mViewPage.setCurrentItem(2, false);
                break;
            case R.id.center_rb:
                mViewPage.setCurrentItem(3, false);
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mHomeRb.setChecked(true);
                break;
            case 1:
                mCollectRb.setChecked(true);
                break;
            case 2:
                mMessageRb.setChecked(true);
                break;
            case 3:
                mCenterRb.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}