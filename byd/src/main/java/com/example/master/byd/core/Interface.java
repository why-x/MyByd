package com.example.master.byd.core;

import com.example.master.byd.bean.About;
import com.example.master.byd.bean.Banners;
import com.example.master.byd.bean.BdcEffectivity;
import com.example.master.byd.bean.BsznDetail;
import com.example.master.byd.bean.BsznL;
import com.example.master.byd.bean.LoginBean;
import com.example.master.byd.bean.MyJDBean;
import com.example.master.byd.bean.MyRealEstate;
import com.example.master.byd.bean.MyYwlx;
import com.example.master.byd.bean.News;
import com.example.master.byd.bean.NewsDetail;
import com.example.master.byd.bean.Registered;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.SMSLoge;
import com.example.master.byd.bean.Search;
import com.example.master.byd.bean.UserBLYW;
import com.example.master.byd.bean.UserBLYWDetail;
import com.example.master.byd.bean.UserInfo;
import com.example.master.byd.bean.WhthinG;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * @author byd
 * @date 2019/5/31 17:29
 */
public interface Interface {
    /**
     * 查验
     *
     * @param bdczh
     * @return
     */
    @FormUrlEncoded
    @POST("realEstate/app/cx/getBdcxx")
    Observable<Result<Search>> getBdcxx(@Field("bdczh") String bdczh);

    /**
     * 最新资讯
     *
     * @return
     */
    @GET("realEstate/app/news/getNews")
    Observable<Result<News>> getNews();

    /**
     * 最新资讯详情
     *
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST("realEstate/app/news/newsDetail")
    Observable<Result<NewsDetail>> newsDetail(@Field("id") String id);


    /**
     * 关于我们
     *
     * @return
     */
    @GET("realEstate/app/aboutus/getAboutUs")
    Observable<Result<About>> getAboutUs();

    /**
     * 图片轮播
     *
     * @return
     */
    @POST("realEstate/app/banner/getBanners")
    Observable<Result<Banners>> getBanners();

    /**
     * 查询所有办事指南列表
     *
     * @return
     */
    @GET("realEstate/app/bszn/getBszns")
    Observable<Result<BsznL>> getBszns(@Query("bdclx") String bdclx);

    /**
     * 查看某个业务的办事指南
     *
     * @param id
     * @return
     */
    @GET("realEstate/app/bszn/getBsznDetail")
    Observable<Result<BsznDetail>> getBsznDetail(@Query("id") String id);


    /**
     * 业务办理 - 查询我能办理的业务列表（即时办结  1）（现场办结    2）
     *
     * @param yhlx
     * @param sfjsbj
     * @return
     */
    @GET("realEstate/app/ywlx/getAllowMyYwlx")
    Observable<Result<MyYwlx>> getAllowMyYwlx(@Query("yhlx") String yhlx,
                                              @Query("sfjsbj") String sfjsbj);

    /**
     * 登录人基本信息
     *
     * @param id
     * @return
     */
    @GET("realEstate/app/login/getUserInfoById")
    Observable<Result<UserInfo>> getUserInfoById(@Query("id") String id);

    /**
     * 业务列表
     *
     * @param sfzh
     * @return
     */
    @GET("realEstate/app/yw/getUserBLYW")
    Observable<Result<UserBLYW>> getUserBLYW(@Query("sfzh") String sfzh);

    /**
     * 查看业务详细信息成功
     *
     * @param sqbid
     * @return
     */
    @GET("realEstate/app/yw/getUserBLYWDetail")
    Observable<Result<UserBLYWDetail>> getUserBLYWDetail(@Query("sqbid") String sqbid);

    /**
     * 注册
     *
     * @param realName
     * @param idnumber
     * @param verCode
     * @param phoneNumber
     * @return
     */
    @GET("realEstate/login/registered")
    Observable<Result<Registered>> registered(@Query("realName") String realName,
                                              @Query("idnumber") String idnumber,
                                              @Query("verCode") String verCode,
                                              @Query("phoneNumber") String phoneNumber);

    /**
     * 登陆
     *
     * @param phoneNumber
     * @param notevcode
     * @return
     */
    @GET("realEstate/app/login/registered")
    Observable<Result<LoginBean>> getlogin(@Query("phoneNumber") String phoneNumber,
                                           @Query("notevcode") String notevcode);

    /**
     * 注册验证码
     *
     * @param loginName
     * @return
     */
    @GET("realEstate/app/login/getSMSReg")
    Observable<Result<SMSLoge>> getSMSReg(@Query("loginName") String loginName);

    /**
     * 登陆验证码
     *
     * @param loginName
     * @return
     */
    @GET("realEstate/app/login/getSMSLoge")
    Observable<Result<SMSLoge>> getSMSLoge(@Query("loginName") String loginName);

    /**
     * 个人办件进度查询
     *
     * @param cxlx
     * @param zjh
     * @param slbh
     * @return
     */
    @GET("realEstate/app/jdcx/getMyJD")
    Observable<Result<MyJDBean>> getMyJD(@Query("cxlx") String cxlx,
                                         @Query("zjh") String zjh,
                                         @Query("slbh") String slbh);

    /**
     * 单位办件进度查询
     *
     * @param cxlx
     * @param slbh
     * @param dwmc
     * @return
     */
    @GET("realEstate/app/jdcx/getMyJD")
    Observable<Result<MyJDBean>> getDWMyJD(@Query("cxlx") String cxlx,
                                           @Query("slbh") String slbh,
                                           @Query("dwmc") String dwmc);

    //

    //    /**
    //     * 头像或昵称更新
    //     *
    //     * @param id
    //     * @param nc
    //     * @param tx
    //     * @return
    //     */
    //    @Multipart
    //    @POST("realEstate/app/login/updateUserInfoById")
    //    Observable<Result> updateUserInfoById(@Query("id") String id,
    //                                          @Query("nc") String nc,
    //                                          @Part("tx") MultipartBody.Part tx);
    @Multipart
    @POST("realEstate/app/login/updateUserInfoById")
    Observable<Result> updateUserInfoById(@PartMap() Map<String, RequestBody> map,
                                          @Part() MultipartBody.Part tx);
//    @Multipart
//    @POST("upload")

//    Call<ResponseBody> uploadFile(@Part("body") RequestBody body, @Part MultipartBody.Part file);

    /**
     * 我的产权
     *
     * @param sfzhm
     * @return
     */
    @FormUrlEncoded
    @POST("realEstate/app/yw/getMyRealEstate")
    Observable<Result<MyRealEstate>> getMyRealEstate(@Field("sfzhm") String sfzhm);

    /**
     * 查档服务 个人  家庭
     *
     * @param cdr
     * @return
     */
    @FormUrlEncoded
    @POST("realEstate/app/cx/whthin")
    Observable<Result<WhthinG>> getwhthin(@Field("cdr") String cdr);


    /**
     * 卖方数据核验
     *
     * @param bdcqz
     * @return
     */
    @GET("realEstate/app/yw/checkBdcEffectivity")
    Observable<Result<BdcEffectivity>> checkBdcEffectivity(@Query("bdcqz") String bdcqz);


    /**
     * 接收外网申请  申请信息填写保存
     *
     * @param bdcsqb
     * @return
     */
    @FormUrlEncoded
    @POST("realEstate/app/yw/saveBdcSqxx")
    Observable<Result<WhthinG>> saveBdcSqxx(@Field("bdcsqb") String bdcsqb);

    /**
     * 删除买方人员信息
     *
     * @param qlrid
     * @return
     */
    @GET("realEstate/app/yw/delBdcMsr")
    Observable<Result> delBdcMsr(@Query("qlrid") String qlrid);

    /**
     * 修改买方人员信息
     *
     * @param qlrid
     * @param gyfelx
     * @return
     */
    @GET("realEstate/app/yw/modifyBdcMsr")
    Observable<Result<WhthinG>> modifyBdcMsr(@Query("qlrid") String qlrid,
                                             @Query("name") String name,
                                             @Query("gyfelx") String gyfelx);

    /**
     * 提交给买\卖方认证
     *
     * @param slbh
     * @param realName
     * @return
     */
    @GET("realEstate/app/yw/sendCheck")
    Observable<Result<WhthinG>> sendCheck(@Query("slbh") String slbh,
                                          @Query("realName") String realName);


    /**
     * 身份证认证
     *
     * @param url
     * @param image
     * @param side
     * @return
     */
    @Headers("Authorization:APPCODE 32c934460e1046cb94be3a93319538c4")
    @FormUrlEncoded
    @POST()
    Observable<Result> shenfenz(@Url() String url,//http(s)://yixi.market.alicloudapi.com/ocr/idcard
                                        @Field("image") String image,
                                        @Field("side") String side);


}
