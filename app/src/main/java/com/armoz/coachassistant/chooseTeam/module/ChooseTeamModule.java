package com.armoz.coachassistant.chooseTeam.module;

import com.armoz.coachassistant.chooseTeam.presenter.ChooseTeamPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ChooseTeamModule {

    public ChooseTeamModule() {
    }

    @Provides
    ChooseTeamPresenter chooseTeamPresenter() {
        return new ChooseTeamPresenter();
    }
}