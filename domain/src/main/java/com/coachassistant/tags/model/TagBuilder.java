package com.coachassistant.tags.model;

public class TagBuilder {
    private long timeInMillis;
    private TagTypeEnum type;
    private long videoId;

    public static TagBuilder tag(){
        return new TagBuilder();
    }

    public TagBuilder setTimeInMillis(long timeInMillis) {
        this.timeInMillis = timeInMillis;
        return this;
    }

    public TagBuilder setType(TagTypeEnum type) {
        this.type = type;
        return this;
    }

    public TagBuilder setVideoId(long id) {
        this.videoId = videoId;
        return this;
    }

    public Tag createTag() {
        return new Tag(timeInMillis, type, videoId);
    }
}