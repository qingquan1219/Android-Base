package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.myapplication.Adapt.HomePageAdapt;
import com.example.myapplication.fragment.CenterFragment;
import com.example.myapplication.fragment.CollectionFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.MessageFragment;

import java.util.ArrayList;

/**
 * AppCompatActivity的由来：
 * v4：Activity 发展到3.0（大概）之后，可以使用fragment了，但是support v4 提供了 1.6~3.0 的fragment兼容
 * v7：所以如果需要用兼容版的fragment，则需要继承support v4提供的FragmentActivity。
 *     而后一点点时间之后，3.0（大概）出现的ActionBar也被向前支持了，这次是出现在support v7里，
 *     如果需要使用兼容版的actionbar，则继承support v7提供的ActionBarActivity（它是继承FragmentActivity的）。
 * OS　5.0：
 * 　再然后5.0提供了很多很多新东西，于是support v7也更新了，出现了AppCompatActivity。
 *
 * 注意：一定要用　AppCompatActivity　或者　一切和　AppCompatXXXXXX，系统内部考虑兼容
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{
    private ViewPager mViewPage;
    private RadioButton mHomeRb;
    private RadioButton mCollectionRb;
    private RadioButton mMessageRb;
    private RadioButton mCenterRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private final void initView() {
        mViewPage = (ViewPager)findViewById(R.id.view_page);
        mHomeRb = (RadioButton) findViewById(R.id.home_rb);
        mCollectionRb = (RadioButton) findViewById(R.id.collection_rb);
        mMessageRb = (RadioButton) findViewById(R.id.message_rb);
        mCenterRb = (RadioButton) findViewById(R.id.center_rb);

        mHomeRb.setOnClickListener(this);
        mCollectionRb.setOnClickListener(this);
        mMessageRb.setOnClickListener(this);
        mCenterRb.setOnClickListener(this);

        mViewPage.setOnPageChangeListener(this);

    }

    private final void initDate() {
        //给viewPager设置Adapter
        ArrayList<Fragment> fragments = new ArrayList<>();
        //1、往集合里面添加Fragment
        fragments.add(new HomeFragment());
        fragments.add(new CollectionFragment());
        fragments.add(new MessageFragment());
        fragments.add(new CenterFragment());
        //2、适配器
        HomePageAdapt homePageAdapt = new HomePageAdapt(getSupportFragmentManager(), fragments);
        mViewPage.setAdapter(homePageAdapt);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_rb:
                mViewPage.setCurrentItem(0, false);
                break;
            case R.id.collection_rb:
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mHomeRb.setChecked(true);
                break;
            case 1:
                mCollectionRb.setChecked(true);
            case 2:
                mMessageRb.setChecked(true);
            case 3:
                mCenterRb.setChecked(true);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}