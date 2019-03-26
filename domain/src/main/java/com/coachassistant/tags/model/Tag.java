package com.coachassistant.tags.model;

public class Tag {

    private final long timeInMillis;
    private final TagTypeEnum type;
    private final long videoId;

    public Tag(long timeInMillis, TagTypeEnum type, long videoId) {
        this.timeInMillis = timeInMillis;
        this.type = type;
        this.videoId = videoId;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public TagTypeEnum getType() {
        return type;
    }

    public long getVideoId() {
        return videoId;
    }
}
