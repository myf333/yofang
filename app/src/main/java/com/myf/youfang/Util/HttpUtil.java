package com.myf.youfang.Util;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by myf on 2015/10/20.
 */
public class HttpUtil {
    private static OkHttpClient client = new OkHttpClient();
    private static String uriAPI = "https://api.f9ke.com/api";

    static{
        try {
            TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            SSLContext e = SSLContext.getInstance("TLS");
            e.init(null, new TrustManager[]{tm}, null);
            client.setSslSocketFactory(e.getSocketFactory());
            client.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static String Get(String controller,String action,Map<String,String> params) throws Exception {
        String url = String.format("%s/%s/%s",uriAPI,controller,action);
        if(params.size()>0){
            url += "?";
            int i = 0;
            for (String param:
                    params.keySet()) {
                if (i == 0) {
                    url += String.format("%s=%s", param, params.get(param));
                } else {
                    url += String.format("&%s=%s", param, params.get(param));
                }
                i++;
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "text/json")
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("请求失败,code: " + response);
        return response.body().string();
    }

    public static String Post(String controller,String action,Map<String,String> params) throws Exception{
        String url = String.format("%s/%s/%s",uriAPI,controller,action);
        FormEncodingBuilder builder = new FormEncodingBuilder();
        if(params != null&&params.size()>0)
        {
            for (String param:
                    params.keySet()) {
                builder.add(param,params.get(param));
            }
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("请求失败,code: " + response);
        return response.body().string();
    }
}
