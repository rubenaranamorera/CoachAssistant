package com.armoz.coachassistant.scouting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.armoz.coachassistant.R;
import com.armoz.coachassistant.base.activity.BaseActivity;
import com.armoz.coachassistant.scouting.component.DaggerScoutingComponent;
import com.armoz.coachassistant.scouting.module.ScoutingModule;
import com.armoz.coachassistant.scouting.presenter.ScoutingPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ScoutingActivity extends BaseActivity implements ScoutingPresenter.View {

    @Inject
    ScoutingPresenter presenter;

    public static Intent buildIntent(Context context) {
        return new Intent(context, ScoutingActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);
        ButterKnife.bind(this);
        initializeInjector();
        presenter.setView(this);
    }

    private void initializeInjector() {
        DaggerScoutingComponent.builder()
                .applicationComponent(getApplicationComponent())
                .scoutingModule(new ScoutingModule())
                .build()
                .inject(this);
    }
}
