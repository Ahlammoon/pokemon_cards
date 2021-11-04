package com.example.pokemon_cards.repository;

//import android.database.Observable;

import com.example.pokemon_cards.model.PokemoResponse;
import com.example.pokemon_cards.network.PokemonApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;



public class Repositry {


        private PokemonApiService pokemonApiService;

        @Inject
        public Repositry(PokemonApiService pokemonApiService) {
            this.pokemonApiService = pokemonApiService;

        }

        public Observable<PokemoResponse> getPokemons() {
            return pokemonApiService.getPokemons();
        }
    }



