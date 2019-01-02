package zhuyue.bwie.com.zhuyue20190102.present;

import java.util.Map;

import zhuyue.bwie.com.zhuyue20190102.bean.HomeBean;
import zhuyue.bwie.com.zhuyue20190102.contract.ReqContract;
import zhuyue.bwie.com.zhuyue20190102.momdel.HomeModel;


public class LoginPresenter {
    private HomeModel homeModel;
    private ReqContract.IHomeView iHomeView;

    public LoginPresenter(ReqContract.IHomeView iLoginView) {
        this.iHomeView = iHomeView;
        this.homeModel = new HomeModel();
    }

    public void goLogin(Map<String, String> params, String api) {
        //正则表达式验证合法性
        if (iHomeView != null) {
            homeModel.setDara(params, api, new ReqContract.OkHttpCallBack() {
                @Override
                public void onSuccess(String res) {
                    if (iHomeView != null) {
                        iHomeView.onSuccess(res);
                    }
                }

                @Override
                public void onFilure(String meg) {
                if (iHomeView!=null){
                    iHomeView.onFilure(meg);
                }

                }
            });
        }
    }

}
