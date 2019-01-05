package com.example.nizar.my_sportdb;

import org.json.JSONObject;
import java.io.Serializable;

public class Sport {
    String strSport,strSportThumb,strSportDescription;

    public Sport(String strSport, String strSportThumb, String strSportDescription) {
        this.strSport = strSport;
        this.strSportThumb = strSportThumb;
        this.strSportDescription = strSportDescription;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrSportThumb() {
        return strSportThumb;
    }

    public void setStrSportThumb(String strSportThumb) {
        this.strSportThumb = strSportThumb;
    }

    public String getStrSportDescription() {
        return strSportDescription;
    }

    public void setStrSportDescription(String strSportDescription) {
        this.strSportDescription = strSportDescription;
    }
}
