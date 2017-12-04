package com.zhiyuan.myzhihu.util;

import android.content.Context;

import com.zhiyuan.myzhihu.global.Constants;

/**
 * Created by admin on 2017/12/4.
 */

public class ThemeUtil {

    private SharePreferencesHelper mSPHelper;
    private static ThemeUtil themeUtil;

    public ThemeUtil(Context mContext) {
        mSPHelper=SharePreferencesHelper.getInstance(mContext);
    }

    public static ThemeUtil getInstance(Context mContext){
        if(themeUtil==null){
            themeUtil=new ThemeUtil(mContext);
        }
        return themeUtil;
    }

    public void setTheme(String theme){
        SharePreferencesHelper.putString(Constants.key.ThemeMode,theme);
    }

    public String getTheme(){
       return SharePreferencesHelper.getString(Constants.key.ThemeMode,Constants.Theme.DAY_THEME);
    }

}
