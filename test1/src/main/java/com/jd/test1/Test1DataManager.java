package com.jd.test1;

import com.jd.common.model.BaseDataManager;
import com.jd.common.model.DataManager;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

/**
 * @author：LiuXiaoDong on 2018/4/20 18:26.
 */

public class Test1DataManager extends BaseDataManager{

    public Test1DataManager(DataManager mDataManager) {
        super(mDataManager);
    }

    public static Test1DataManager getInstance(DataManager dataManager){
        return new Test1DataManager(dataManager);
    }

    /*
     *获取测试数据  （只做示例，无数据返回）
     */
    public Disposable test1Data(DisposableObserver<ResponseBody> consumer, String mobile, String verifyCode) {

        return changeIOToMainThread(getService(Test1ApiService.class).test1Data(mobile,verifyCode), consumer);
    }
}
