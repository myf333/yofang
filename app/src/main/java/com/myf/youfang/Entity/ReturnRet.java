package com.myf.youfang.Entity;

/**
 * Created by myf on 2015/10/20.
 */
public class ReturnRet<T>
{
    /// <summary>
    /// 是否成功
    /// </summary>
    private Boolean success;
    /// <summary>
    /// 消息
    /// </summary>
    private String message;
    /// <summary>
    /// 返回数据
    /// </summary>
    private T data ;

    public Boolean getSuccess(){
        return success;
    }
    public void setSuccess(Boolean success){
        this.success = success;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }
}
