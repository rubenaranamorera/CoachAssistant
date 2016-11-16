package com.armoz.coachassistant.base;

import android.app.Application;

import com.armoz.coachassistant.base.component.ApplicationComponent;
import com.armoz.coachassistant.base.component.DaggerApplicationComponent;
import com.armoz.coachassistant.base.module.ApplicationModule;

public class AndroidApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    this.initializeInjector();
  }

  private void initializeInjector() {
    this.applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }
}
