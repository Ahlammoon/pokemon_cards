package com.example.pokemon_cards.model;

public class Pokemon {

    private String name;
    private  String url;
   // private  String type_name;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
