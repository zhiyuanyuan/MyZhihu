package com.zhiyuan.myzhihu.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zhiyuan.myzhihu.R;
import com.zhiyuan.myzhihu.global.Constants;
import com.zhiyuan.myzhihu.util.ThemeUtil;
import com.zhiyuan.myzhihu.util.ToastUtils;

/**
 * Created by admin on 2017/12/4.
 */

public class BaseActivity extends AppCompatActivity implements BaseFuncIml{

    private ThemeUtil mThemeUtil;

    private int mFragmentId;

    protected Fragment mCurrFragment;
    private boolean exit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initTheme();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initData();
        initView();
        initListener();
        initLoad();

    }
    public void setFragmentId(int fragmentId) {
        mFragmentId = fragmentId;
    }

    public Fragment getCurrFragment() {
        return mCurrFragment;
    }

    public void setCurrFragment(Fragment currFragment) {
        this.mCurrFragment = currFragment;
    }

   protected  void toFragment(Fragment toFragment){
       if (mCurrFragment == null) {
           ToastUtils.showToast(this, "mCurrFragment is null");
           return;
       }

       if (toFragment == null) {
           ToastUtils.showToast(this, "toFragment is null");
           return;
       }
       if(toFragment.isAdded()){
           getSupportFragmentManager().beginTransaction()
                   .hide(mCurrFragment)
                   .show(toFragment)
                   .commit();
       }else {
           getSupportFragmentManager().beginTransaction()
                   .hide(mCurrFragment)
                   .add(mFragmentId,toFragment)
                   .show(toFragment)
                   .commit();
       }
   }
    protected void openActivity(Class<? extends BaseActivity> toActivity) {
        openActivity(toActivity, null);
    }
   protected  void  openActivity(Class<? extends BaseActivity> toActivity,Bundle bundle){
       Intent intent=new Intent(this,toActivity);
       if(bundle!=null){
           intent.putExtras(bundle);
       }
       startActivity(intent);
   }

   public void setExit(boolean exit){
       this.exit=exit;
   }

   protected  void setToolbar(Toolbar toolbar, String title){
       toolbar.setTitle(title);
       setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setDisplayShowHomeEnabled(true);
       toolbar.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });


   }

    private void initTheme() {
        mThemeUtil = ThemeUtil.getInstance(this);
        String theme = mThemeUtil.getTheme();
        switch (theme) {
            case Constants.Theme.DAY_THEME:
                setTheme(R.style.DayTheme);
                break;

            case Constants.Theme.NIGHT_THEME:
                setTheme(R.style.NightTheme);
                break;

            default:
                setTheme(R.style.DayTheme);
                break;
        }
    }


    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {

    }
}
