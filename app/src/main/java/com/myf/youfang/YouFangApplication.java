package com.myf.youfang;

import android.app.Application;

import com.myf.youfang.Entity.User;
import com.myf.youfang.Util.SharedPreferencesUtil;

/**
 * Created by myf on 2015/10/19.
 */
public class YouFangApplication extends Application {
    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public User getUser(){
        if(user ==null){
            this.user = SharedPreferencesUtil.getUser(this);
        }
        return user;
    }

    public void setUser(User user){
        SharedPreferencesUtil.saveUser(this,user);
        this.user = user;
    }
}
