package com.example.master.byd.uitls;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManager {

    private static NetWorkManager instance;
    private Retrofit retrofit;
    public static final String BASE_URL = "http://47.110.150.232:9999";

    private NetWorkManager(){
        init();
    }

    public static NetWorkManager getInstance() {
        if (instance == null){
            instance = new NetWorkManager();
        }
        return instance;
    }

    private void init(){


        OkHttpClient okHttpClient = getClient();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
//        47.110.150.232
                .baseUrl(BASE_URL)//base_url:http+域名
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用Rxjava对回调数据进行处理
                .addConverterFactory(GsonConverterFactory.create())//响应结果的解析器，包含gson，xml，protobuf
                .build();
    }

    public <T> T create(final Class<T> service){
        return retrofit.create(service);
    }

    public synchronized static OkHttpClient getClient(){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            builder.connectTimeout(60,TimeUnit.SECONDS)
                    .writeTimeout(60,TimeUnit.SECONDS)
                    .readTimeout(60,TimeUnit.SECONDS);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
            try {
                // 自定义一个信任所有证书的TrustManager，添加SSLSocketFactory的时候要用到
                final X509TrustManager trustAllCert =
                        new X509TrustManager() {
                            @Override
                            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                            }

                            @Override
                            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                            }

                            @Override
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return new java.security.cert.X509Certificate[]{};
                            }
                        };
                final SSLSocketFactory sslSocketFactory = new SSLSocketFactoryCompat(trustAllCert);
                builder.sslSocketFactory(sslSocketFactory, trustAllCert).hostnameVerifier(getTrustedVerifier());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        return builder.build();
    }

    private static HostnameVerifier TRUSTED_VERIFIER;

    private static HostnameVerifier getTrustedVerifier() {
        if (TRUSTED_VERIFIER == null)
            TRUSTED_VERIFIER = new HostnameVerifier() {

                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

        return TRUSTED_VERIFIER;
    }

}
