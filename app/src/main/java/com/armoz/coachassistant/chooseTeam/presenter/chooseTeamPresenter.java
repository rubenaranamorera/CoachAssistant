
package com.armoz.coachassistant.chooseTeam.presenter;

import com.armoz.coachassistant.base.viewModel.TeamViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.armoz.coachassistant.base.viewModel.TeamViewModelBuilder.teamViewModel;

public class ChooseTeamPresenter {
    private View view;


    public ChooseTeamPresenter() {
    }

    public void setView(View view) {
        this.view = view;
    }

    public void loadTeams() {
        List<TeamViewModel> teamsList = new ArrayList<>();
        teamsList.add(teamViewModel().setClub("Roser").setName("senior B").setCategory("2a Catalana").build());
        view.onTeamsLoaded(teamsList);
    }

    public interface View {
        void onTeamsLoaded(List<TeamViewModel> teamsList);
    }
}
