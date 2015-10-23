package com.myf.youfang.Entity;

/**
 * Created by myf on 2015/10/20.
 */
public class RegUserView {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(String lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCareeryear() {
        return careeryear;
    }

    public void setCareeryear(String careeryear) {
        this.careeryear = careeryear;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExpnum() {
        return expnum;
    }

    public void setExpnum(int expnum) {
        this.expnum = expnum;
    }

    public Boolean getExpreienceToday() {
        return ExpreienceToday;
    }

    public void setExpreienceToday(Boolean expreienceToday) {
        ExpreienceToday = expreienceToday;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Boolean getIsdeliver() {
        return isdeliver;
    }

    public void setIsdeliver(Boolean isdeliver) {
        this.isdeliver = isdeliver;
    }

    private String id;
    /// <summary>
    /// 用户名
    /// </summary>
    private String username;
    /// <summary>
    /// 姓名
    /// </summary>
    private String name;
    /// <summary>
    /// 电话
    /// </summary>
    private String phone;
    /// <summary>
    /// 市
    /// </summary>
    private String city;
    /// <summary>
    /// 性别
    private String sex;
    /// <summary>
    /// 头像图片地址
    /// </summary>
    private String avatarurl;
    /// <summary>
    /// 最后登录时间
    /// </summary>
    private String lastlogindate;
    /// <summary>
    /// 经纪公司id
    /// </summary>
    private String companyid;
    /// <summary>
    /// 经纪公司名
    /// </summary>
    private String companyname;
    /// <summary>
    /// 出生日期
    /// </summary>
    private String birthday;
    /// <summary>
    /// 从业年数
    /// </summary>
    private String careeryear;
    /// <summary>
    /// 学历
    /// </summary>
    private String degree;
    /// <summary>
    /// 身份
    /// </summary>
    private String position;
    /// <summary>
    /// 自我简历
    /// </summary>
    private String desc;
    /// <summary>
    /// 积分
    /// </summary>
    private int expnum;
    /// <summary>
    /// 当天是否可以签到
    /// </summary>
    private Boolean ExpreienceToday;
    /// <summary>
    /// 区域
    /// </summary>
    private String district;
    /// <summary>
    /// 是否接送
    /// </summary>
    private Boolean isdeliver;
}
