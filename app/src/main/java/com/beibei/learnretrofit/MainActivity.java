package com.beibei.learnretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.beibei.learnretrofit.bean.MovieSubject;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * https://www.jianshu.com/p/811ba49d0748
 *
 * */
public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BasicParamsInterceptor interceptor = new BasicParamsInterceptor.Builder()
//                .addHeaderParam("userName", "")
//                .addHeaderParam("device", "")
//                .build();
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(10, TimeUnit.SECONDS)
//                .writeTimeout(10, TimeUnit.SECONDS)
//                .readTimeout(10, TimeUnit.SECONDS)
//                .addInterceptor(interceptor)
//                .build();
//
//        //创建Retrofit实例
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(okHttpClient)
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();

        //一次封装
       /* MovieService service = RetrofitServiceManager.getInstance().create(MovieService.class);
        //获取接口实例
//        MovieService service = retrofit.create(MovieService.class);
        Observable<MovieSubject> observable = service.getTops250(0, 1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieSubject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieSubject movieSubject) {
                        Log.e("top250", movieSubject.toString());
                        Log.e("top250", movieSubject.getSubjects().toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

        //调用方法得到一个Call
//        Call<MovieSubject> call = service.getTops250(0, 1);

        //进行网络请求(异步方式请求)
//        call.enqueue(new Callback<MovieSubject>() {
//            @Override
//            public void onResponse(Call<MovieSubject> call, Response<MovieSubject> response) {
//                Log.e("top250", response.toString());
//                Log.e("top250", response.body().getSubjects().toString());
//            }
//
//            @Override
//            public void onFailure(Call<MovieSubject> call, Throwable t) {
//
//            }
//        });


        //同步方式请求
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Response<MovieSubject> response = call.execute();
//                    Log.e("top250", response.body().getSubjects().toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                }
//            }
//        }).start();

        getData();
    }

    //二次封装
    private void getData() {
        new MovieLoader().getMovie(0, 1).subscribe(
                new Consumer<List<MovieSubject.Movie>>() {
                    @Override
                    public void accept(List<MovieSubject.Movie> movies) throws Exception {
                        Log.e("top250", movies.toString());
                    }
                },
                new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
