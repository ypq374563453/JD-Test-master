package com.jd.test1;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.basejd.app_common.service.ITestService;

/**
 * @author liuxiaodong
 * @date 2018/12/1
 * @description
 */

@Route(path = "/testService/TestService", name = "测试服务")
public class Test1Service implements ITestService {

    private Context context;


    @Override
    public void init(Context context) {
        this.context = context;
    }

    @Override
    public String getTestPackageName() {
        return context.getPackageName();
    }
}
