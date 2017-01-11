package com.armoz.coachassistant.createTeam.component;

import com.armoz.coachassistant.base.component.ApplicationComponent;
import com.armoz.coachassistant.createTeam.activity.CreateTeamActivity;
import com.armoz.coachassistant.createTeam.module.CreateTeamModule;
import com.armoz.coachassistant.createTeam.presenter.CreateTeamPresenter;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class, modules = {CreateTeamModule.class})
public interface CreateTeamComponent {
    void inject(CreateTeamActivity createTeamActivity);

    CreateTeamPresenter createTeamPresenter();

}
