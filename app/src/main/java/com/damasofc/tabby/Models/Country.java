package com.damasofc.tabby.Models;

/**
 * Created by damasofc on 11-16-17.
 */

public class Country {
    private String name;
    private String code;

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlagUrl(){
        return "http://www.geognos.com/api/en/countries/flag/"+code+".png";
    }

}
