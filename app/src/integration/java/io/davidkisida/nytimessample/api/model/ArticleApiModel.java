package io.davidkisida.nytimessample.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

import io.davidkisida.nytimessample.common.util.EmptyStringArrayAwareDeserializer;

public class ArticleApiModel {

    @JsonProperty("url")
    private String url;

    @JsonProperty("adx_keywords")
    private String adxKeywords;

    @JsonProperty("column")
    private String column;

    @JsonProperty("section")
    private String section;

    @JsonProperty("byline")
    private String byline;

    @JsonProperty("type")
    private String type;

    @JsonProperty("title")
    private String title;

    @JsonProperty("abstract")
    private String aAbstract;

    @JsonProperty("published_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date publishedDate;

    @JsonProperty("source")
    private String source;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("asset_id")
    private Long assetId;

    @JsonProperty("views")
    private Long views;

    @JsonProperty("des_facet")
    @JsonDeserialize(using = EmptyStringArrayAwareDeserializer.class)
    private List<String> desFacet;

    @JsonProperty("org_facet")
    @JsonDeserialize(using = EmptyStringArrayAwareDeserializer.class)
    private List<String> orgFacet;

    @JsonProperty("per_facet")
    @JsonDeserialize(using = EmptyStringArrayAwareDeserializer.class)
    private List<String> perFacet;

    @JsonProperty("geo_facet")
    @JsonDeserialize(using = EmptyStringArrayAwareDeserializer.class)
    private List<String> geoFacet;

    @JsonProperty("media")
    private List<MediaApiModel> mediaList;

    public String getUrl() {
        return url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public String getColumn() {
        return column;
    }

    public String getSection() {
        return section;
    }

    public String getByline() {
        return byline;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAAbstract() {
        return aAbstract;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public String getSource() {
        return source;
    }

    public Long getId() {
        return id;
    }

    public Long getAssetId() {
        return assetId;
    }

    public Long getViews() {
        return views;
    }

    public List<String> getDesFacet() {
        return desFacet;
    }

    public List<String> getOrgFacet() {
        return orgFacet;
    }

    public List<String> getPerFacet() {
        return perFacet;
    }

    public List<String> getGeoFacet() {
        return geoFacet;
    }

    public List<MediaApiModel> getMediaList() {
        return mediaList;
    }
}
