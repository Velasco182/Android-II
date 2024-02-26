package com.example.consumo.apipokemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.consumo.R
import com.squareup.picasso.Picasso

class PokemonAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPokemonName: TextView = view.findViewById(R.id.tvPokemonName)
        val ivPokemon : ImageView = view.findViewById(R.id.ivPokemon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        Picasso.get().load("https://i.pinimg.com/originals/04/5a/6b/045a6bf929075321781c3b4805b0dbfc.png").into(holder.ivPokemon)
        holder.tvPokemonName.text = pokemon.name
    }

    override fun getItemCount() = pokemonList.size
}
