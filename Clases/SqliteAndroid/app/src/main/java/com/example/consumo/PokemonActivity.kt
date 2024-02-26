package com.example.consumo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.consumo.apipokemon.Pokemon
import com.example.consumo.apipokemon.PokemonApiService
import com.example.consumo.apipokemon.PokemonRespuesta
import com.example.consumo.databinding.ActivityPokemonBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ///Inflar actividad con Binding
        binding = ActivityPokemonBinding.inflate(LayoutInflater.from(this))
        ///Require context
        setContentView(binding.root)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofitBuilder.create(PokemonApiService::class.java)

        val call = service.getPokemonByID(20) //Consulta el pokemon por ID

        call.enqueue(object : Callback<Pokemon> {

            override fun onResponse (call: Call<PokemonRespuesta>, response: Response<PokemonRespuesta>) {

                if(response.isSuccessful){
                    val pokemon: PokemonRespuesta? = response.body()
                    var listaPokemones = ArrayList<Pokemon>()

                    listaPokemones = (pokemon?.results ?:

                    //haz lo que quieras con la info del pokemon
                    Toast.makeText(this@PokemonActivity, "El consumido es $listaPokemones", Toast.LENGTH_SHORT).show()) as ArrayList<Pokemon>
                    binding.textView.text = pokemon.toString()
                }else{
                    //Manejar errores
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                //Manejar errores de la red
            }

        })
    }
}