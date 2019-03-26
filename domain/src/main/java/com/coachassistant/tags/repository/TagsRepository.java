package com.coachassistant.tags.repository;

import com.coachassistant.tags.model.Tag;

import java.util.List;

public interface TagsRepository {

    void saveTag(Tag tag);

    List<Tag> loadTags(long videoId);
}
