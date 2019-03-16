package com.beibei.learnretrofit;


import com.beibei.learnretrofit.bean.MovieSubject;
import com.beibei.learnretrofit.common.RetrofitServiceManager;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public class MovieLoader extends ObjectLoader {
    private MovieService mMovieService;

    public MovieLoader() {
        mMovieService = RetrofitServiceManager.getInstance().create(MovieService.class);
    }

    //第一次封装
    /**
     * 获取电影列表
     */
    public Observable<List<MovieSubject.Movie>> getMovie(int start, int count) {
        return observe(mMovieService.getTop250(start, count))
                .map(new Function<MovieSubject, List<MovieSubject.Movie>>() {
                    @Override
                    public List<MovieSubject.Movie> apply(MovieSubject movieSubject) throws Exception {
                        return movieSubject.getSubjects();
                    }
                });
    }

    //第二次封装 失败 待解救
//    /**
//     * 获取电影列表
//     */
//    public Observable<List<MovieSubject.Movie>> getMovie(int start, int count){
//        return observe(mMovieService.getTop250(start,count))
//                .map(new DealDataFunction<BaseResponse<List<MovieSubject.Movie>>>());
//    }

    public interface MovieService {
        //获取豆瓣Top250 榜单
        @GET("top250")
        Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count") int count);

        @FormUrlEncoded
        @POST("/x3/weather")
        Call<String> getWeather(@Field("cityId") String cityId, @Field("key") String key);
    }
}