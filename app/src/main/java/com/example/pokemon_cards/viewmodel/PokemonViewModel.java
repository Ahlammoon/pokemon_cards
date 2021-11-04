package com.example.pokemon_cards.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.pokemon_cards.model.PokemoResponse;
import com.example.pokemon_cards.model.Pokemon;
import com.example.pokemon_cards.repository.Repositry;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PokemonViewModel extends ViewModel {

    private Repositry repositry;
    private MutableLiveData<ArrayList<Pokemon>> pokemonList = new MutableLiveData<>();
    private LiveData<List<Pokemon>> favList = null;

    public LiveData<List<Pokemon>> getFavList() {
        return favList;
    }

    @ViewModelInject
    public PokemonViewModel(Repositry repositry) {
        this.repositry = repositry;
    }

    public MutableLiveData<ArrayList<Pokemon>> getPokemonList() {
        return pokemonList;
    }




    @SuppressLint("CheckResult")
    public void getPokemons() {
        repositry.getPokemons()
                .subscribeOn(Schedulers.io())
                .map(new Function<PokemoResponse, ArrayList<Pokemon>>() {
                    @Override
                    public ArrayList<Pokemon> apply(PokemoResponse pokemoResponse) throws Throwable {
                        ArrayList<Pokemon> list = pokemoResponse.getResult();
                        for (Pokemon pokemon : list) {
                            String url = pokemon.getUrl();
                            String[] pokemonIndex = url.split("/");

                            pokemon.setUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/"+pokemonIndex[pokemonIndex.length - 1]+".png");
                        }
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> pokemonList.setValue(result),
                        error -> Log.e("viwModel", error.getMessage()));
    }
}