package com.jd.test1;

import com.jd.common.model.http.BaseApiService;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author：admin on 2018/4/20 18:26.
 */

public interface Test1ApiService extends BaseApiService{

    @FormUrlEncoded
    @POST("userRegister/test1")
    Observable<ResponseBody> test1Data(@Field("xxx") String mobile, @Field("xxx") String code);
}
