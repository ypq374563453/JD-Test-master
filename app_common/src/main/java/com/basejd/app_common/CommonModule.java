package com.basejd.app_common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jd.common.base.BaseArouter;
import com.squareup.leakcanary.LeakCanary;
import com.jd.common.GlobalAppComponent;

/**
 * @author liuxiaodong
 * @date 2018/12/1
 * @description
 */
public class CommonModule {
    public static void init(Application application){

        if (LeakCanary.isInAnalyzerProcess(application)) {
            return;
        }
        if(BuildConfig.DEBUG){
            LeakCanary.install(application);
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }

        ARouter.init(application);
        //CrashReport.initCrashReport(getApplicationContext(), "93f0e37549", CommonConfig.DEBUG);
        Fresco.initialize(application);
        GlobalAppComponent.init(application);

        //平行module初始化
        ARouter.getInstance().build(BaseArouter.Main.InitMain).navigation();
        ARouter.getInstance().build(BaseArouter.Test.InitTest).navigation();
        ARouter.getInstance().build(BaseArouter.Test1.InitTest1).navigation();
    }
}
