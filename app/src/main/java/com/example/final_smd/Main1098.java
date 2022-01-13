package com.example.final_smd;

import java.util.Date;

public class Main1098 {
    AT at;
    HWS hws;
    PRE pre;

    public AT getAt() {
        return at;
    }

    public void setAt(AT at) {
        this.at = at;
    }

    public HWS getHws() {
        return hws;
    }

    public void setHws(HWS hws) {
        this.hws = hws;
    }

    public PRE getPre() {
        return pre;
    }

    public void setPre(PRE pre) {
        this.pre = pre;
    }

    public Date first_UTC;

    public Date last_UTC;

    public int month_ordinal;

    public String northern_season;

    public String season;

    public String southern_season;

    public Date getFirst_UTC() {
        return first_UTC;
    }

    public void setFirst_UTC(Date first_UTC) {
        this.first_UTC = first_UTC;
    }

    public Date getLast_UTC() {
        return last_UTC;
    }

    public void setLast_UTC(Date last_UTC) {
        this.last_UTC = last_UTC;
    }

    public int getMonth_ordinal() {
        return month_ordinal;
    }

    public void setMonth_ordinal(int month_ordinal) {
        this.month_ordinal = month_ordinal;
    }

    public String getNorthern_season() {
        return northern_season;
    }

    public void setNorthern_season(String northern_season) {
        this.northern_season = northern_season;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSouthern_season() {
        return southern_season;
    }

    public void setSouthern_season(String southern_season) {
        this.southern_season = southern_season;
    }
}
