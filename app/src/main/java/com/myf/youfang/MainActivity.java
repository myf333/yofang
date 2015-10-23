package com.myf.youfang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

public class MainActivity extends BaseActivity {

    private ImageView btnLeft;
    private ImageView btnRight;
    private RelativeLayout btnAll;
    private RelativeLayout btnPublish;
    private MapView mapView;
    private BaiduMap baiduMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化百度地图
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        btnLeft = (ImageView)findViewById(R.id.left);
        btnLeft.setOnClickListener(this);
        btnRight = (ImageView)findViewById(R.id.right);
        btnRight.setOnClickListener(this);
        btnAll = (RelativeLayout)findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);
        btnPublish = (RelativeLayout)findViewById(R.id.btnPublish);
        btnPublish.setOnClickListener(this);
        initView();
    }

    private void initView() {
        mapView = (MapView)findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();
        //声明LocationClient类
        LocationClient mLocationClient = new LocationClient(getApplicationContext());
        //注册监听函数
        mLocationClient.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                if(bdLocation!=null){
                    double dx = bdLocation.getLongitude();
                    double dy = bdLocation.getLatitude();
                    //定义Maker坐标点
                    LatLng point = new LatLng(dy, dx);
                    //构建Marker图标
                    BitmapDescriptor bitmap = BitmapDescriptorFactory
                            .fromResource(R.mipmap.icon_geo);
                    //构建MarkerOption，用于在地图上添加Marker
                    OverlayOptions option = new MarkerOptions()
                            .position(point)
                            .icon(bitmap)
                            .zIndex(20)  //设置marker所在层级
                            .draggable(true);  //设置手势拖拽
                    //在地图上添加Marker，并显示
                    baiduMap.addOverlay(option);
                }
            }
        });

        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        option.setScanSpan(0);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(false);//可选，默认false,设置是否使用gps
        option.setLocationNotify(false);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(false);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(false);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认false，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要

        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // activity 恢复时同时恢复地图控件
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // activity 暂停时同时暂停地图控件
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // activity 销毁时同时销毁地图控件
        mapView.onDestroy();
        mapView = null;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.left:
                if(isLogin()){

                }else{
                    Intent intent = new Intent(this,LoginActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.right:
                if(isLogin()){

                }else{
                    Intent intent = new Intent(this,LoginActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.btnAll:
                break;
            case R.id.btnPublish:
                if(isLogin()){

                }else{
                    Intent intent = new Intent(this,LoginActivity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
