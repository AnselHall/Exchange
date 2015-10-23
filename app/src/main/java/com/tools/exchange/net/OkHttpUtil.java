package com.tools.exchange.net;

import android.text.TextUtils;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tools.exchange.utils.JsonUtil;

import java.io.IOException;

/**
 * Created by user on 2015/10/23.
 */
public class OkHttpUtil {

    private static String json;

//    public static <T> T getBeanByUrl(String url, final Class<T> clazz) {
    public static <T> T getBeanByUrl(String url, final Class<T> clazz) {

        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url(url)
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                json = response.body().string();
            }
        });

        if (!TextUtils.isEmpty(json)) {
            return JsonUtil.parseJsonToBean(json, clazz);
        } else {
            return null;
        }
    }
}
