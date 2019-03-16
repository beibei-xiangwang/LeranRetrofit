package com.beibei.learnretrofit;

import com.beibei.learnretrofit.bean.MovieSubject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author: anbeibei
 * <p>
 * date: 2019/3/15
 * <p>
 * desc:
 */
public interface MovieService {

    //获取豆瓣Top250 榜单
//    @GET("top250")
//    Call<MovieSubject> getTops250(@Query("start") int start, @Query("count") int count);

//    @FormUrlEncoded
//    @POST("top250")
//    Call<MovieSubject> getTops250(@Field("start") int start, @Field("count") int count);

    @GET("top250")
    Observable<MovieSubject> getTops250(@Query("start") int start, @Query("count") int count);

}
