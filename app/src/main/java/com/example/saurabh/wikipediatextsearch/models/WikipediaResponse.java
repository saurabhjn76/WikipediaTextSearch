package com.example.saurabh.wikipediatextsearch.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by danilolemes on 13/10/2017.
 */

public class WikipediaResponse implements Serializable {

    @SerializedName("continue")
    private WikipediaContinue wikiContinue;
    private WikipediaQuery query;

    public WikipediaResponse() {
    }


    public WikipediaResponse(WikipediaContinue wikiContinue, WikipediaQuery query) {
        this.wikiContinue = wikiContinue;
        this.query = query;
    }

    public WikipediaQuery getQuery() {
        return query;
    }

    public void setQuery(WikipediaQuery query) {
        this.query = query;
    }

    public WikipediaContinue getWikiContinue() {
        return wikiContinue;
    }

    public void setWikiContinue(WikipediaContinue wikiContinue) {
        this.wikiContinue = wikiContinue;
    }
}
