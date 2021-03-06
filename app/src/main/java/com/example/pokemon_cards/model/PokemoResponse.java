package com.example.pokemon_cards.model;

import java.util.ArrayList;

public class PokemoResponse {

    private int count;
    private String next,previous;
    private ArrayList<Pokemon> result;


    public PokemoResponse(int count, String next, String previous, ArrayList<Pokemon> result) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<Pokemon> getResult() {
        return result;
    }

    public void setResult(ArrayList<Pokemon> result) {
        this.result = result;
    }
}
