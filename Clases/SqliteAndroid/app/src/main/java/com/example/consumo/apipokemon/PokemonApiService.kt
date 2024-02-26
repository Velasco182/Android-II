package com.example.consumo.apipokemon

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService{
    @GET("pokemon/{id}")

    fun getPokemonByID(@Path("id") id:Int): Call<PokemonRespuesta>

}