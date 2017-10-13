package com.example.saurabh.wikipediatextsearch.models;

import java.io.Serializable;

/**
 * Created by danilolemes on 13/10/2017.
 */

public class WikipediaContinue implements Serializable {

    private Integer sroffset;

    public WikipediaContinue() {
    }

    public WikipediaContinue(Integer sroffset) {
        this.sroffset = sroffset;
    }

    public Integer getSroffset() {
        return sroffset;
    }

    public void setSroffset(Integer sroffset) {
        this.sroffset = sroffset;
    }
}
