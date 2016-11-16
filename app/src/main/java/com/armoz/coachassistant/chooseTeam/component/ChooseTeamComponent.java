package com.armoz.coachassistant.chooseTeam.component;

import com.armoz.coachassistant.base.component.ApplicationComponent;
import com.armoz.coachassistant.chooseTeam.activity.ChooseTeamActivity;
import com.armoz.coachassistant.chooseTeam.module.ChooseTeamModule;
import com.armoz.coachassistant.chooseTeam.presenter.ChooseTeamPresenter;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class, modules = {ChooseTeamModule.class})
public interface ChooseTeamComponent {
    void inject(ChooseTeamActivity chooseTeamActivity);

    ChooseTeamPresenter chooseTeamPresenter();

}
