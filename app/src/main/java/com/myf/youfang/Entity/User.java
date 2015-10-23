package com.myf.youfang.Entity;

/**
 * Created by myf on 2015/10/19.
 */
public class User {
    /*
     * 用户id
     */
    private String id;

    /*
     * 登录名
     */
    private String userName;
    /*
     * 姓名
     */
    private String name;

    /*
     * 手机号
     */
    private String phone;

    /*
     * 省份
     */
    public String province;
    /*
     * 城市
     */
    public String city;
    /*
     * 区域
     */
    public String region;
    /*
     * 性别
     */
    public String sex;
    /*
     * 学历
     */
    public String degrees;
    /*
     * 头像图片地址
     */
    public String avatarurl;
    /*
     * 经纪公司id
     */
    public String companyid;
    /*
     * 经纪公司名
     */
    public String companyname;
    /*
     * 出生日期
     */
    public String birthday;
    /*
     * 年龄
     */
    public String age;
    /*
     * 简历
     */
    public String resume;
    /*
     * 工作年限
     */
    public String workingYears;
    /*
     * 身份
     */
    public String position;
    /*
     * 是否接送
     */
    public String isdeliver;

    public String getRegion() {
        return region;
    }

    public String getIsdeliver() {
        return isdeliver;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setIsdeliver(String isdeliver) {
        this.isdeliver = isdeliver;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyid() {
        return companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getSex() {
        return sex;
    }

    public String getDegrees() {
        return degrees;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public String getAge() {
        return age;
    }

    public String getResume() {
        return resume;
    }

    public String getWorkingYears() {
        return workingYears;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setWorkingYears(String workingYears) {
        this.workingYears = workingYears;
    }

}
