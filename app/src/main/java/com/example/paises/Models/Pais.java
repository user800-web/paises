package com.example.paises.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pais {
    public String Name;
    @JsonIgnore
    public String Capital;
    @JsonIgnore
    public String GeoRectangle;
    @JsonIgnore
    public int SeqID;
    @JsonIgnore
    public Float[] GeoPt;
    public String TelPref;
    public CountryCodes CountryCodes;
    public String CountryInfo;

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

    public String getGeoRectangle() {
        return GeoRectangle;
    }

    public void setGeoRectangle(String geoRectangle) {
        GeoRectangle = geoRectangle;
    }

    public int getSeqID() {
        return SeqID;
    }

    public void setSeqID(int seqID) {
        SeqID = seqID;
    }

    public Float[] getGeoPt() {
        return GeoPt;
    }

    public void setGeoPt(Float[] geoPt) {
        GeoPt = geoPt;
    }

    public String getTelPref() {
        return TelPref;
    }

    public void setTelPref(String telPref) {
        TelPref = telPref;
    }

    public com.example.paises.Models.CountryCodes getCountryCodes() {
        return CountryCodes;
    }

    public void setCountryCodes(com.example.paises.Models.CountryCodes countryCodes) {
        CountryCodes = countryCodes;
    }

    public String getCountryInfo() {
        return CountryInfo;
    }

    public void setCountryInfo(String countryInfo) {
        CountryInfo = countryInfo;
    }


    public static ArrayList<Pais> JsonObjectsBuild(Respuesta respuesta){
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(respuesta.Results.BD);
        paises.add(respuesta.Results.BE);
        paises.add(respuesta.Results.BF);
        paises.add(respuesta.Results.BG);
        paises.add(respuesta.Results.BA);
        paises.add(respuesta.Results.BB);
        paises.add(respuesta.Results.WF);
        paises.add(respuesta.Results.BL);
        paises.add(respuesta.Results.BM);
        paises.add(respuesta.Results.BN);
        paises.add(respuesta.Results.BO);
        paises.add(respuesta.Results.BH);
        paises.add(respuesta.Results.BI);
        paises.add(respuesta.Results.BJ);
        paises.add(respuesta.Results.BT);
        paises.add(respuesta.Results.JM);
        paises.add(respuesta.Results.BV);
        return paises;
    }
}
