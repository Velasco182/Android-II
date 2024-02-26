package com.example.consumo.apipokemon

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService{
    //@GET("pokemon/{pokemon}")

    fun getPokemonByID(@Path("pokemon") id:String): Call<Pokemon>

    @GET("pokemon")
    fun getPokemon() : Call<PokemonRespuesta>

}