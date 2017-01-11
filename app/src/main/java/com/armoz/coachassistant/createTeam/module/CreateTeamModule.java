package com.armoz.coachassistant.createTeam.module;

import com.armoz.coachassistant.createTeam.presenter.CreateTeamPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateTeamModule {

    public CreateTeamModule() {
    }

    @Provides
    CreateTeamPresenter createTeamPresenter() {
        return new CreateTeamPresenter();
    }
}