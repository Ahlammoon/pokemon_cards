package com.example.pokemon_cards.network;

import com.example.pokemon_cards.model.PokemoResponse;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokemonApiService {


    // function bring Api
    @GET("pokemon")
    Observable<PokemoResponse> getPokemons();
}
