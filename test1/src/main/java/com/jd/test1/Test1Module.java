package com.jd.test1;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.jd.common.base.BaseArouter;

/**
 * @author admin
 * @date 2018/12/1
 * @description
 */
@Route(path = BaseArouter.Test1.InitTest1, name = "模块初始化")
public class Test1Module implements IProvider {
    private static final String TAG = "Test1Module";
    @Override
    public void init(Context context) {
        Log.e(TAG, "TestModule调用了初始化" );
    }
}
