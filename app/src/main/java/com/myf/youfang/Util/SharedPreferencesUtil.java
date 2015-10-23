package com.myf.youfang.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.myf.youfang.Entity.User;

/**
 * Created by myf on 2015/10/19.
 */
public class SharedPreferencesUtil {
    public static void saveUser(Context context,User user){
        SharedPreferences.Editor editor = context.getSharedPreferences("SP",context.MODE_PRIVATE).edit();
        editor.putString("user.id",user.getId());
        editor.putString("user.userName", user.getUserName());
        editor.putString("user.name", user.getName());
        editor.putString("user.phone", user.getPhone());
        editor.putString("user.avatarurl", user.getAvatarurl());
        editor.putString("user.province", user.getProvince());
        editor.putString("user.city", user.getCity());
        editor.putString("user.region", user.getRegion());
        editor.putString("user.sex", user.getSex());
        editor.putString("user.age", user.getAge());
        editor.putString("user.resume", user.getResume());
        editor.putString("user.workingYears", user.getWorkingYears());
        editor.putString("user.degrees", user.getDegrees());
        editor.putString("user.birthday", user.getBirthday());
        editor.putString("user.isdeliver", user.getIsdeliver());

        editor.commit();
    }

    public static User getUser(Context context)
    {
        SharedPreferences sp = context.getSharedPreferences("SP",context.MODE_PRIVATE);
        User user = new User();
        user.setId(sp.getString("user.id", ""));
        user.setUserName(sp.getString("user.userName", ""));
        user.setName(sp.getString("user.name", ""));
        user.setAvatarurl(sp.getString("user.avatarurl", ""));
        user.setPhone(sp.getString("user.phone", ""));
        user.setDegrees(sp.getString("user.degrees", ""));
        user.setProvince(sp.getString("user.province", ""));
        user.setCity(sp.getString("user.city", ""));
        user.setRegion(sp.getString("user.region", ""));
        user.setSex(sp.getString("user.sex", ""));
        user.setWorkingYears(sp.getString("user.workingYears", ""));
        user.setResume(sp.getString("user.resume", ""));
        user.setAge(sp.getString("user.age", ""));
        user.setBirthday(sp.getString("user.birthday", ""));
        user.setIsdeliver(sp.getString("user.isdeliver", ""));

        return user;
    }
}
