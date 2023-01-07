package com.example.paises.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Respuesta {
    public String StatusMsg;
    public Paises Results;
    public String StatusCode;

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    public Paises getResults() {
        return Results;
    }

    public void setResults(Paises results) {
        Results = results;
    }

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }
}
