package com.armoz.coachassistant.base.component;

import android.content.Context;

import com.armoz.coachassistant.base.activity.BaseActivity;
import com.armoz.coachassistant.base.module.ApplicationModule;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
}
