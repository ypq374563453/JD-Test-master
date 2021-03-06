package com.jd.main.composition.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jd.common.base.BaseArouter;
import com.jd.common.base.rxjava.ErrorDisposableObserver;
import com.jd.main.MainDataManager;
import com.jd.main.R;
import com.jd.common.base.BaseActivity;

import okhttp3.ResponseBody;

/**
 * @author Admin
 */
@Route(path = BaseArouter.Main.LoginActivity)
public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

    }

    /**
     * 模拟登录网络请求，只做演示无返回
     */
    public void login(){
        addDisposable(MainDataManager.getInstance(mDataManager).login(new ErrorDisposableObserver<ResponseBody>() {
            @Override
            public void onNext(ResponseBody responseBody) {

            }

            @Override
            public void onComplete() {

            }
        },"mobile","code"));
    }
}
