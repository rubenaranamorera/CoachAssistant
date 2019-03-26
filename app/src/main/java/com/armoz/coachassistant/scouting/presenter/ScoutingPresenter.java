
package com.armoz.coachassistant.scouting.presenter;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import com.coachassistant.tags.model.Tag;
import com.coachassistant.tags.model.TagBuilder;
import com.coachassistant.tags.model.TagTypeEnum;
import com.coachassistant.tags.service.TagsService;
import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.FFmpegLoadBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;

import static android.content.Context.DOWNLOAD_SERVICE;

public class ScoutingPresenter {
    private View view;
    private TagsService tagsService;

    public ScoutingPresenter(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void initializeFFmpeg(Context context) {
        final FFmpeg fFmpeg = FFmpeg.getInstance(context);
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

    public void createTag(int currentPosition) {
        Tag tag =  TagBuilder.tag()
            .setTimeInMillis(1)
                .setType(TagTypeEnum.OTHER)
                .setVideoId(1)
                .createTag();

        tagsService.saveTag(tag);
    }



    public void startDownload(Context context, String url) {
        Uri uri = Uri.parse("http://www.sample-videos.com/video/mp4/240/big_buck_bunny_240p_2mb.mp4");
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setTitle("Some title");
        request.setDescription("Some video downloading using DownloadManager.");

        request.setDestinationInExternalFilesDir(context,Environment.DIRECTORY_DOWNLOADS,"somevid.mp4");

        downloadManager.enqueue(request);
    }


    public interface View {
        void FFmpegNotSupportedShowError();

        void onFFMpegInitialized();
    }
}
