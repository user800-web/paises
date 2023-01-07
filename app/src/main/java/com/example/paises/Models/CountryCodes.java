package com.example.paises.Models;

public class CountryCodes {
    public String tld;
    public String iso3;
    public String iso2;
    public String fips;
    public int isoN;
    public String abreviatura;

    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = "http://www.geognos.com/api/en/countries/flag/"+iso2+".png";
        setAbreviatura(iso2);
    }

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    public int getIsoN() {
        return isoN;
    }

    public void setIsoN(int isoN) {
        this.isoN = isoN;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
}
