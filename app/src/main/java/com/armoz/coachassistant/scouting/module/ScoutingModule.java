package com.armoz.coachassistant.scouting.module;

import com.armoz.coachassistant.scouting.presenter.ScoutingPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ScoutingModule {

    public ScoutingModule() {
    }

    @Provides
    ScoutingPresenter scoutingPresenter() {
        return new ScoutingPresenter();
    }
}