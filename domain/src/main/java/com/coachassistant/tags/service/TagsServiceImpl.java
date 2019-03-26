package com.coachassistant.tags.service;

import com.coachassistant.tags.model.Tag;
import com.coachassistant.tags.repository.TagsRepository;

import java.util.List;

public class TagsServiceImpl implements TagsService {

    private TagsRepository tagsRepository;

    public TagsServiceImpl(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    @Override
    public void saveTag(Tag tag) {
        tagsRepository.saveTag(tag);
    }

    @Override
    public List<Tag> loadTags() {
        return tagsRepository.loadTags(tag.getVideoId());
    }
}
