package com.jd.common.base;

/**
 * @auther：ypq created on 2019/11/30 19:30
 * @model：
 * @description：Arouter类注解声明path常量
 */
public class BaseArouter {
    public class App {
        public final static String ModuleTestActivity = "/app/ModuleTestActivity";
    }

    public class Main {
        public final static String InitMain = "/MainModule/MainModule";
        public final static String LoginActivity = "/main/login";
        public final static String MainActivity = "/main/MainActivity";

    }

    public class Test {
        public final static String InitTest = "/TestModule/TestModule";
        public final static String TestActivity = "/test/activity";
    }

    public class Test1 {
        public final static String InitTest1 = "/Test1Module/Test1Module";
        public final static String LoginActivity = "/test1/login";
    }
}
