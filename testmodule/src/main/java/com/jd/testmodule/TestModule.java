package com.jd.testmodule;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.jd.common.base.BaseArouter;

/**
 * @author liuxiaodong
 * @date 2018/12/1
 * @description
 */
@Route(path = BaseArouter.Test.InitTest, name = "模块初始化")
public class TestModule implements IProvider {
    private static final String TAG = "TestModule";
    @Override
    public void init(Context context) {
        Log.e(TAG, "TestModule调用了初始化" );
    }
}
