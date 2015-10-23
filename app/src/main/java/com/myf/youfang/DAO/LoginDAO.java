package com.myf.youfang.DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myf.youfang.Entity.RegUserView;
import com.myf.youfang.Entity.ReturnRet;
import com.myf.youfang.Util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by myf on 2015/10/20.
 */
public class LoginDAO {
    public ReturnRet<RegUserView> login(String username, String password) {
       Map<String,String> params = new HashMap<String,String>();
        params.put("username", username);
        params.put("password", password);
        String res = "";
        ReturnRet<RegUserView> ret = null;
        try {
            res = HttpUtil.Post("RegUser", "Login", params);
            Gson gson = new Gson();
            ret = gson.fromJson(res,new TypeToken<ReturnRet<RegUserView>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
