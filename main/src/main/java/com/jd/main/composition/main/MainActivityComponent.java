package com.jd.main.composition.main;

import com.jd.common.AppComponent;
import com.jd.common.PerActivity;

import dagger.Component;

/**
 * Created by admin on 2017/3/12.
 */
@PerActivity
@Component(dependencies = AppComponent.class , modules = MainPresenterModule .class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
