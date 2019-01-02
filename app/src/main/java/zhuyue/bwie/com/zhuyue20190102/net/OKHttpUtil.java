package zhuyue.bwie.com.zhuyue20190102.net;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import zhuyue.bwie.com.zhuyue20190102.contract.ReqContract;

public class OKHttpUtil {
    private static OKHttpUtil instance;
    private final OkHttpClient okHttpClient;
    private final Handler handler;

    private OKHttpUtil(){

        handler = new Handler();

        //设置拦截器
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();

        okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }
     public static OKHttpUtil getInstanse(){
       if (instance==null){
           synchronized (OKHttpUtil.class){
               if (instance==null){
                   instance = new OKHttpUtil();
               }
           }
       }

        return instance;
     }
     public void toPost(Map<String,String>params, String api, final ReqContract.OkHttpCallBack okHttpCallBack){
         FormBody.Builder formBody = new FormBody.Builder();
         for (Map.Entry<String, String> p : params.entrySet()) {
         formBody.add(p.getKey(),p.getValue());
         }

         final Request request = new Request.Builder()
                 .post(formBody.build())
                 .url(api)
                 .build();

         okHttpClient.newCall(request).enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {
                 handler.post(new Runnable() {
                     @Override
                     public void run() {
                         okHttpCallBack.onFilure("网络错误");
                     }
                 });
             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 final String res = response.body().string();
                 if (okHttpCallBack!=null){
                     handler.post(new Runnable() {
                         @Override
                         public void run() {
                        okHttpCallBack.onSuccess(res);
                         }
                     });
                 }
             }
         });

     }

    public void cancelAllTask(){
        if (okHttpClient!=null){
            okHttpClient.dispatcher().cancelAll();
        }
    }
}
