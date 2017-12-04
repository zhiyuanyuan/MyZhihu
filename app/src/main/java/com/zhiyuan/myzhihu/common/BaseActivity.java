package com.zhiyuan.myzhihu.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.zhiyuan.myzhihu.R;
import com.zhiyuan.myzhihu.global.Constants;
import com.zhiyuan.myzhihu.util.ThemeUtil;

/**
 * Created by admin on 2017/12/4.
 */

public class BaseActivity extends AppCompatActivity {

    private ThemeUtil mThemeUtil;

    private int mFragmentId;

    protected Fragment mCurrFragment;
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



}
