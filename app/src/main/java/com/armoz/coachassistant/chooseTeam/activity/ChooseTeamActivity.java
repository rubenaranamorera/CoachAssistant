package com.armoz.coachassistant.chooseTeam.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.armoz.coachassistant.R;
import com.armoz.coachassistant.base.activity.BaseActivity;
import com.armoz.coachassistant.base.viewModel.TeamViewModel;
import com.armoz.coachassistant.chooseTeam.adapter.TeamAdapter;
import com.armoz.coachassistant.chooseTeam.component.DaggerChooseTeamComponent;
import com.armoz.coachassistant.chooseTeam.module.ChooseTeamModule;
import com.armoz.coachassistant.chooseTeam.presenter.ChooseTeamPresenter;
import com.armoz.coachassistant.createTeam.activity.CreateTeamActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseTeamActivity extends BaseActivity implements ChooseTeamPresenter.View {

    @BindView(R.id.teamList)
    public RecyclerView teamListView;

    @BindView(R.id.emptyState)
    public View emptyStateView;

    private RecyclerView.Adapter teamAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Inject
    ChooseTeamPresenter presenter;

    public static Intent buildIntent(Context context) {
        return new Intent(context, ChooseTeamActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);
        ButterKnife.bind(this);
        initializeInjector();
        presenter.setView(this);
        presenter.loadTeams();
    }


    @Override
    public void onTeamsLoaded(List<TeamViewModel> teamsList) {
        if (teamsList == null || teamsList.isEmpty()) {
            emptyStateView.setVisibility(View.VISIBLE);
        } else {
            showTeamList(teamsList);
        }
    }


    @OnClick(R.id.createTeamButton)
    public void goToCreateTeamActivity() {
        Intent intent = CreateTeamActivity.buildIntent(this);
        this.startActivity(intent);
    }

    private void showTeamList(List<TeamViewModel> teamsList) {
        layoutManager = new LinearLayoutManager(this);
        teamListView.setLayoutManager(layoutManager);

        teamAdapter = new TeamAdapter(teamsList);
        teamListView.setAdapter(teamAdapter);

        teamListView.setVisibility(View.VISIBLE);
    }

    private void initializeInjector() {
        DaggerChooseTeamComponent.builder()
                .applicationComponent(getApplicationComponent())
                .chooseTeamModule(new ChooseTeamModule())
                .build()
                .inject(this);
    }
}

