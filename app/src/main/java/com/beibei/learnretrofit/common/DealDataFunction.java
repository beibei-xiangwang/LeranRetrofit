package com.beibei.learnretrofit.common;


import io.reactivex.functions.Function;

/**
 * @author: anbeibei
 * <p>
 * date: 2019/3/16
 * <p>
 * desc:  DealDataFunction 继承自Function,接收一个BaseResponse<T> ,
 * 就是接口返回的JSON数据结构，返回的是T,就是data,
 * 判断是否请求成功，请求成功返回Data,请求失败包装成一个Fault 返回给上层统一处理错误。
 */

public class DealDataFunction<T> implements Function<BaseResponse<T>, T> {
    @Override
    public T apply(BaseResponse<T> tBaseResponse) {//获取数据失败时，包装一个Fault 抛给上层处理错误
        if (!tBaseResponse.isSuccess()) {
            throw new Fault(tBaseResponse.status, tBaseResponse.message);
        }
        return tBaseResponse.data;
    }
}
