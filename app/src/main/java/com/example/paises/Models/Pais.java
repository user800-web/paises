package com.example.paises.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pais {
    public String Name;
    public String Capital;
    public String TelPref;
    public String iso;
    public String CountryInfo;
    public String urlBandera;

    public Pais(JSONObject a) throws JSONException {
        Name =  a.getString("Name").toString();
        if (!a.isNull("Capital")) {
            JSONObject countryCapital = a.getJSONObject("Capital");
            Capital =   countryCapital.getString("Name").toString() ;
        }else Capital="No Tiene Capital";
        JSONObject countryCode = a.getJSONObject("CountryCodes");
        iso = countryCode.getString("iso2");
        urlBandera =  "http://www.geognos.com/api/en/countries/flag/"+iso+".png";
        TelPref =  a.getString("TelPref").toString() ;
        CountryInfo =  a.getString("CountryInfo").toString() ;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getTelPref() {
        return TelPref;
    }

    public void setTelPref(String telPref) {
        TelPref = telPref;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getCountryInfo() {
        return CountryInfo;
    }

    public void setCountryInfo(String countryInfo) {
        CountryInfo = countryInfo;
    }

    public String getUrlBandera() {
        return urlBandera;
    }

    public void setUrlBandera(String urlBandera) {
        this.urlBandera = urlBandera;
    }
}
