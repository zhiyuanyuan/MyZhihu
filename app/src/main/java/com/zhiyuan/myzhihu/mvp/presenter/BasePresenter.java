package com.zhiyuan.myzhihu.mvp.presenter;

import com.zhiyuan.myzhihu.rx.RxManager;

/**
 * Created by admin on 2017/12/5.
 */

public abstract class BasePresenter<M ,V > {
   public  M model;
   public V view;
   public RxManager mRxManager=new RxManager();

   public void attachVM(M model,V view){
       this.model=model;
       this.view=view;
   }

   public void detachVM(){
       model=null;
       view=null;
       mRxManager.clear();
   }

}
