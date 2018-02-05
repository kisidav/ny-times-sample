package io.davidkisida.nytimessample.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MostViewedApiModel {

    @JsonProperty("status")
    private String status;

    @JsonProperty("copyright")
    private String copyright;

    @JsonProperty("num_results")
    private Integer numResults;

    @JsonProperty("results")
    private List<ArticleApiModel> results;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public List<ArticleApiModel> getResults() {
        return results;
    }
}
