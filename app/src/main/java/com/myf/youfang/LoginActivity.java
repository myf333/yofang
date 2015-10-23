package com.myf.youfang;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.myf.youfang.DAO.LoginDAO;
import com.myf.youfang.Entity.RegUserView;
import com.myf.youfang.Entity.ReturnRet;
import com.myf.youfang.Entity.User;

import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LoginActivity extends BaseActivity {
    ImageButton btnLeft;
    Button btnLogin;
    ReturnRet<RegUserView> ret;
    private MyHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLeft = (ImageButton)findViewById(R.id.left);
        btnLeft.setOnClickListener(this);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        mHandler = new MyHandler(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.left:
                finish();
                break;
            case R.id.btnLogin:
                doLogin();
                break;
            default:
                break;
        }
    }

    static class MyHandler extends Handler {
        private WeakReference<LoginActivity> mOuter;

        public MyHandler(LoginActivity activity) {
            mOuter = new WeakReference<>(activity);
        }
        public void handleMessage(Message msg) {
            switch (msg.arg1){
                case 1:
                    LoginActivity outer = mOuter.get();
                    if (outer != null) {
                        if (outer.ret != null && outer.ret.getSuccess()) {
                            User user = new User();
                            user.setId(outer.ret.getData().getId());
                            user.setUserName(outer.ret.getData().getUsername());
                            user.setName(outer.ret.getData().getName());
                            user.setPhone(outer.ret.getData().getPhone());
                            user.setCity(outer.ret.getData().getCity());
                            user.setRegion(outer.ret.getData().getDistrict());
                            user.setSex(outer.ret.getData().getSex());
                            user.setAvatarurl(outer.ret.getData().getAvatarurl());
                            user.setCompanyid(outer.ret.getData().getCompanyid());
                            user.setCompanyname(outer.ret.getData().getCompanyname());
                            user.setDegrees(outer.ret.getData().getDegree());
                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
                                if (outer.ret.getData().getBirthday() != null) {
                                    Date date = sdf.parse(outer.ret.getData().getBirthday());
                                    user.setBirthday(sdf.format(date));
                                }
                                if (outer.ret.getData().getCareeryear() != null){
                                    Date date = sdf.parse(outer.ret.getData().getCareeryear());
                                    user.setWorkingYears(sdf.format(date));
                                }
                            }catch (ParseException ex){
                                ex.printStackTrace();
                            }
                            user.setResume(outer.ret.getData().getDesc());
                            user.setPosition(outer.ret.getData().getPosition());
                            outer.app.setUser(user);
                            Intent intent = new Intent(outer, MainActivity.class);
                            outer.startActivity(intent);
                            outer.finish();
                        } else {
                            if (outer.ret != null) {
                                Toast.makeText(outer, outer.ret.getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(outer, "服务器请求异常，请稍后再试", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void doLogin()
    {
        if(isNetWorkConnected()){
            EditText txtUserName = (EditText)findViewById(R.id.phone);
            final String userName = txtUserName.getText().toString();
            if(userName.equals("")){
                Toast.makeText(LoginActivity.this, "请填写用户名", Toast.LENGTH_SHORT).show();
                return;
            }
            EditText txtPassword = (EditText)findViewById(R.id.password);
            final String password = txtPassword.getText().toString();
            if(password.equals("")){
                Toast.makeText(LoginActivity.this, "请填写密码", Toast.LENGTH_SHORT).show();
                return;
            }

            new Thread(){
                public void run(){
                    LoginDAO dao = new LoginDAO();
                    ret = dao.login(userName,password);
                    Message msg = mHandler.obtainMessage();
                    msg.arg1 = 1;
                    msg.sendToTarget();
                }
            }.start();
        }else{
            Toast.makeText(LoginActivity.this,R.string.network_error,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
