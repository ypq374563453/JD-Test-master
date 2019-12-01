package com.jd.main.composition.main.classificationfragment;

import com.jd.common.PerFragment;
import com.jd.common.AppComponent;

import dagger.Component;

/**
 * Created by admin on 2017/3/12.
 */
@PerFragment
@Component(dependencies = AppComponent.class , modules = ClassificationPresenterModule.class)
public interface ClassificationFragmentComponent {
    void inject(ClassificationFragment fragment);
}
