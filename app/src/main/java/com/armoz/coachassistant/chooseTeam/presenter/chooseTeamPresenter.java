
package com.armoz.coachassistant.chooseTeam.presenter;

import java.util.ArrayList;
import java.util.List;

public class ChooseTeamPresenter {
    private View view;


    public ChooseTeamPresenter() {
    }

    public void setView(View view) {
        this.view = view;
    }

    public void loadTeams() {
        List<String> teamsList = new ArrayList<>();//Arrays.asList("TEAM A", "TEAM B", "TEAM C");

        view.onTeamsLoaded(teamsList);
    }

    public interface View {

        void onTeamsLoaded(List<String> teamsList);

    }
}
