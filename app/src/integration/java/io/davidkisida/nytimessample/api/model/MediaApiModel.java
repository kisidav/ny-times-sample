package io.davidkisida.nytimessample.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MediaApiModel {

    @JsonProperty("type")
    private String type;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("caption")
    private String caption;

    @JsonProperty("copyright")
    private String copyright;

    @JsonProperty("approved_for_syndication")
    private Long approvedForSycdication;

    @JsonProperty("media-metadata")
    private List<MediaMetadataApiModel> mediaMetadata;

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getCaption() {
        return caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public Long getApprovedForSycdication() {
        return approvedForSycdication;
    }

    public List<MediaMetadataApiModel> getMediaMetadata() {
        return mediaMetadata;
    }
}
