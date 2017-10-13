package com.example.saurabh.wikipediatextsearch.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by danilolemes on 13/10/2017.
 */

public class WikipediaQuery implements Serializable {

    private List<WikipediaResultItem> search;

    public WikipediaQuery() {
    }

    public WikipediaQuery(List<WikipediaResultItem> search) {
        this.search = search;
    }

    public List<WikipediaResultItem> getSearch() {
        return search;
    }

    public void setSearch(List<WikipediaResultItem> search) {
        this.search = search;
    }
}
