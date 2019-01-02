package zhuyue.bwie.com.zhuyue20190102.momdel;

import java.util.Map;

import zhuyue.bwie.com.zhuyue20190102.contract.ReqContract;
import zhuyue.bwie.com.zhuyue20190102.net.OKHttpUtil;


public class HomeModel implements ReqContract.OHomeModule {
    @Override
    public void setDara(Map<String, String> params, String api, ReqContract.OkHttpCallBack okHttpCallBack) {
        OKHttpUtil.getInstanse().toPost(params,api,okHttpCallBack);
    }
}
