package com.test.testpokemon.network;

import com.test.testpokemon.model.Pokemon;
import com.test.testpokemon.model.PokemonInformation;
import com.test.testpokemon.model.Pokemons;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GetDataService {

    @GET("pokemon?limit=964")
    Call<Pokemons> getAllPokemon();

    @GET
    Call<PokemonInformation> getSelectedPokemon(@Url String url);

//    @GET("pokemon?limit=964")
//    Call<List<PokemonEntity>> getAllPhotos();
        }