package com.armoz.coachassistant.base.module;

import android.content.Context;

import com.armoz.coachassistant.base.AndroidApplication;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    Context provideApplicationContext() {
        return this.application;
    }
}
