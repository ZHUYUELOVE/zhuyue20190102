package zhuyue.bwie.com.zhuyue20190102.contract;

import java.util.Map;

public interface ReqContract {

    /**
     * OKHttpCallBack
     */

    interface OkHttpCallBack{
        void onSuccess(String res);
        void onFilure(String meg);
    }
    /**
     * model
     */
    interface OHomeModule{
        void setDara(Map<String, String> params, String api, OkHttpCallBack okHttpCallBack);

        }
    /**
     * View
     */
    interface IHomeView{
        void onSuccess(String res);
        void onFilure(String meg);
    }

}
