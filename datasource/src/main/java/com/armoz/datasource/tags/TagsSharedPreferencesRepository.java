package com.armoz.datasource.tags;

import android.content.Context;
import android.content.SharedPreferences;

import com.coachassistant.tags.model.Tag;
import com.coachassistant.tags.repository.TagsRepository;

import java.util.ArrayList;
import java.util.List;

public class TagsSharedPreferencesRepository implements TagsRepository {

    private final Context context;

    public TagsSharedPreferencesRepository(Context context) {
        this.context = context;
    }

    private String getDefaultSharedPreferencesName() {
        return context.getPackageName() + "_preferences";
    }


    @Override
    public void saveTag(Tag tag) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(getDefaultSharedPreferencesName(), context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        List<Tag> tags = loadTags(tag.getVideoId());
        tags.add(tag);

        //TODO: convert to json
        editor.putString(String.valueOf(tag.getVideoId()), "tagsToJson");

        editor.commit();
    }

    @Override
    public List<Tag> loadTags(long videoId) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(getDefaultSharedPreferencesName(), context.MODE_PRIVATE);
        String tagsString = sharedPreferences.getString(String.valueOf(videoId), null);

        //TODO: convert from json

        return new ArrayList<>();
    }
}
