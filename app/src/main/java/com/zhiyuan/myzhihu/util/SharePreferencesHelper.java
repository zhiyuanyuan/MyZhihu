package com.zhiyuan.myzhihu.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by admin on 2017/12/4.
 */

public class SharePreferencesHelper {
    private static final String TAG = "SharePreferencesHelper";
    public static SharePreferencesHelper mSharePreferencesHelper;
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor editor;

    @SuppressLint("WrongConstant")
    public SharePreferencesHelper(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(TAG, Context.MODE_APPEND);
    }

    public static SharePreferencesHelper getInstance(Context mContext){
        if(mSharePreferencesHelper==null){
            return new SharePreferencesHelper(mContext);
        }
        return mSharePreferencesHelper;
    }

    public static boolean putString(String key,String value){
        editor = mSharedPreferences.edit();
        editor.putString(key,value);
       return editor.commit();
    }

   public static String getString(String key){
      return   mSharedPreferences.getString(key,"");
   }

}
