package com.example.ztz.myguanzhongwang.api;

import com.example.ztz.myguanzhongwang.bean.LoginBean;
import com.example.ztz.myguanzhongwang.bean.ShouyeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ztz on 2017/12/15.
 */

public interface API {
    @GET("v1/daily/comic_lists/0")
    Observable<ShouyeBean> getData(@Query("since") String since,@Query("gender")String gender,@Query("sa_event") String sa_event);

    @GET("user/login")
    Observable<LoginBean> getlogin(@Query("mobile") String mobile,@Query("password") String password);

}
