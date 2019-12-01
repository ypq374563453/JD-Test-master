package com.jd.main.composition.main.homefragment;

import com.jd.common.PerFragment;
import com.jd.common.AppComponent;

import dagger.Component;

/**
 * Created by admin on 2017/3/12.
 */
@PerFragment
@Component(dependencies = AppComponent.class , modules = HomePresenterModule.class)
public interface HomeFragmentComponent {
    void inject(MainHomeFragment fragment);
}
