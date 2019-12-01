package com.jd.main.composition.main.findfragment;

import com.jd.common.PerFragment;
import com.jd.common.AppComponent;

import dagger.Component;

/**
 * Created by admin on 2017/3/12.
 */
@PerFragment
@Component(dependencies = AppComponent.class , modules = FindPresenterModule.class)
public interface FindFragmentComponent {
    void inject(FindFragment fragment);
}
