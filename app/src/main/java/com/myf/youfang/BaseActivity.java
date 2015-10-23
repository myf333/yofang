package com.myf.youfang;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by myf on 2015/10/15.
 */
public abstract class BaseActivity extends AppCompatActivity implements OnClickListener {
    protected YouFangApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        app = (YouFangApplication)getApplication();
    }

    @Override
    public void onClick(View v){

    }

    public Boolean isNetWorkConnected()
    {
        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo!=null){
            return  networkInfo.isAvailable();
        }
        return false;
    }

    protected Boolean isLogin(){
        if(app.getUser()!=null&&app.getUser().getId()!=null&&app.getUser().getId()!=""){
            return true;
        }else{
            return false;
        }
    }
}
