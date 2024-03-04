package com.example.consumo

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consumo.apipokemon.Pokemon
import com.example.consumo.apipokemon.PokemonAdapter
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
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        ///Require context
        setContentView(binding.root)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://noticias-api-eosin.vercel.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofitBuilder.create(PokemonApiService::class.java)

        val call = service.getPokemon() //Consulta el pokemon por ID

        call.enqueue(object : Callback<PokemonRespuesta> {

            override fun onResponse(
                call: Call<PokemonRespuesta>,
                response: Response<PokemonRespuesta>
            ) {

                if (response.isSuccessful) {
                    val pokemon: PokemonRespuesta? = response.body()
                    var listaPokemones = pokemon!!.results

                    //listaPokemones = (pokemon?.results ?:
                    for (pokemon in listaPokemones) {

                        //val p: Pokemon = listaPokemones.get(i)
                        //haz lo que quieras con la info del pokemon
                        //Toast.makeText(this@PokemonActivity,"El consumido es ${pokemon.name}", Toast.LENGTH_SHORT).show()

                        //Log.i(TAG, "Pokemon: "+ p.name)
                        // Suponiendo que tienes tu lista de Pokémon lista, inicializa el RecyclerView así:
                        val recyclerView = binding.listPokemon
                        recyclerView.layoutManager = LinearLayoutManager(this@PokemonActivity)
                        // Suponiendo que listaPokemones es tu lista de Pokémon
                        recyclerView.adapter = PokemonAdapter(listaPokemones)
                    }

                } else {
                    //Manejar errores
                }
            }

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {
            // Manejar errores de la red
            }

        })
    }
}
