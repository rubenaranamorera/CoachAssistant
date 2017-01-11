
package com.armoz.coachassistant.createTeam.presenter;

import com.armoz.coachassistant.base.viewModel.TeamViewModel;

public class CreateTeamPresenter {
    private View view;


    public CreateTeamPresenter() {
    }

    public void setView(View view) {
        this.view = view;
    }

    public void createTeam(TeamViewModel teamViewModel) {
        //TODO: Connect to domain, create and persist the team
        view.onTeamCreated();
    }

    public interface View {

        void onTeamCreated();

    }
}
