package com.coachassistant.tags.service;

import com.coachassistant.tags.model.Tag;

import java.util.List;

public interface TagsService {

    void saveTag(Tag tag);

    List<Tag> loadTags();
}
