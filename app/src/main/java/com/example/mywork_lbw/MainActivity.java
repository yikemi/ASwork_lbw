package com.example.mywork_lbw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mTabWeixin;
    private LinearLayout mTabfrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeixinImg;
    private ImageButton mFrdImg;
    private ImageButton mAddressImg;
    private ImageButton mSettingImg;


    private Fragment mTab01 = new weixinFragment();
    private Fragment mTab02 = new frdFragment();
    private Fragment mTab03 = new contactFragment();
    private Fragment mTab04 = new settingsFragment();

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initFragment();
        selectfragment(0);
    }

    private void initFragment() {
        //fragment的切换
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content, mTab01);
        transaction.add(R.id.id_content, mTab02);
        transaction.add(R.id.id_content, mTab03);
        transaction.add(R.id.id_content, mTab04);
        transaction.commit();
    }

    private void initEvent() {
        mTabWeixin.setOnClickListener(this);
        mTabfrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    private void initView() {
        //改变图标的颜色
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabfrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_contact);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);

        mWeixinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddressImg = (ImageButton) findViewById(R.id.id_tab_contact_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);


    }

    private void selectfragment(int i) {
        //显示选中界面的内容，选中界面图标为绿色
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i) {
            case 0:
                Log.d("setSelect", "1");
                transaction.show(mTab01);
                mWeixinImg.setImageResource(R.drawable.weixin1);
                break;
            case 1:
                transaction.show(mTab02);
                mFrdImg.setImageResource(R.drawable.friend1);
                break;
            case 2:
                transaction.show(mTab03);
                mAddressImg.setImageResource(R.drawable.address1);
                break;
            case 3:
                transaction.show(mTab04);
                mSettingImg.setImageResource(R.drawable.setting1);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        //把没有使用的界面的内容隐藏
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    @Override
    public void onClick(View view) {
        //监听函数，监听到底是哪一个图标被击中从而显示哪一个界面的内容
        resetimg();
        switch (view.getId()) {
            case R.id.id_tab_weixin:
                selectfragment(0);
                break;
            case R.id.id_tab_frd:
                selectfragment(1);
                break;
            case R.id.id_tab_contact:
                selectfragment(2);
                break;
            case R.id.id_tab_settings:
                selectfragment(3);
                break;
        }
    }

    public void resetimg() {
        //没有使用的界面的图标为灰色
        mWeixinImg.setImageResource(R.drawable.weixin2);
        mFrdImg.setImageResource(R.drawable.friend2);
        mAddressImg.setImageResource(R.drawable.address2);
        mSettingImg.setImageResource(R.drawable.setting2);
    }
}
