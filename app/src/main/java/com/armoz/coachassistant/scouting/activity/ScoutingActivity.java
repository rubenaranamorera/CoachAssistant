package com.armoz.coachassistant.scouting.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.armoz.coachassistant.R;
import com.armoz.coachassistant.base.activity.BaseActivity;
import com.armoz.coachassistant.scouting.component.DaggerScoutingComponent;
import com.armoz.coachassistant.scouting.module.ScoutingModule;
import com.armoz.coachassistant.scouting.presenter.ScoutingPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScoutingActivity extends BaseActivity implements ScoutingPresenter.View {

    @Inject
    ScoutingPresenter presenter;

    @BindView(R.id.scouting_videoView)
    VideoView videoView;

    @BindView(R.id.scouting_tagButton)
    Button tagButton;

    @BindView(R.id.scouting_downloadInputText)
    TextView downloadInputTextview;

    @BindView(R.id.scouting_downloadButton)
    Button downloadButton;

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

        presenter.initializeFFmpeg(this.getApplicationContext());
    }

    private void initializeInjector() {
        DaggerScoutingComponent.builder()
                .applicationComponent(getApplicationComponent())
                .scoutingModule(new ScoutingModule())
                .build()
                .inject(this);
    }

    @Override
    public void FFmpegNotSupportedShowError() {
        //TODO:show error
    }

    @Override
    public void onFFMpegInitialized() {
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.sample;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    @OnClick(R.id.scouting_tagButton)
    public void createTag(){
        presenter.createTag(videoView.getCurrentPosition());

    }

    @OnClick(R.id.scouting_downloadButton)
    public void download(){
        presenter.startDownload(this.getApplicationContext(), downloadInputTextview.getText().toString());
    }
}
