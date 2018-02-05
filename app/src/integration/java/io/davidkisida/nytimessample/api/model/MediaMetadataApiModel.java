package io.davidkisida.nytimessample.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaMetadataApiModel {

    @JsonProperty("url")
    private String url;

    @JsonProperty("format")
    private String format;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("width")
    private Integer width;

    public String getUrl() {
        return url;
    }

    public String getFormat() {
        return format;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }
}
