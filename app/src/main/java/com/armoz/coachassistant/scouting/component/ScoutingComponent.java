package com.armoz.coachassistant.scouting.component;

import com.armoz.coachassistant.base.component.ApplicationComponent;
import com.armoz.coachassistant.scouting.activity.ScoutingActivity;
import com.armoz.coachassistant.scouting.module.ScoutingModule;
import com.armoz.coachassistant.scouting.presenter.ScoutingPresenter;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class, modules = {ScoutingModule.class})
public interface ScoutingComponent {
    void inject(ScoutingActivity scoutingActivity);

    ScoutingPresenter scoutingPresenter();

}
