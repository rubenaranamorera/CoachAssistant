
package com.armoz.coachassistant.scouting.presenter;

import android.content.Context;

import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.FFmpegLoadBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;

public class ScoutingPresenter {
    private View view;


    public ScoutingPresenter() {
    }

    public void setView(View view) {
        this.view = view;
    }

    public void initializeFFmpeg(Context context) {
        FFmpeg fFmpeg = FFmpeg.getInstance(context);
        try{
            fFmpeg.loadBinary(new FFmpegLoadBinaryResponseHandler() {
                @Override
                public void onFailure() {

                }

                @Override
                public void onSuccess() {

                }

                @Override
                public void onStart() {

                }

                @Override
                public void onFinish() {

                }
            });
        } catch (FFmpegNotSupportedException e) {
            view.FFmpegNotSupportedShowError();
        }
        view.onFFMpegInitialized();
    }

    public void loadVideo() {

    }

    public void createTag(int currentPosition) {
        //TODO: add tag to database 
    }


    public interface View {
        void FFmpegNotSupportedShowError();

        void onFFMpegInitialized();
    }
}
