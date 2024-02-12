package com.example.consumo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.consumo.databinding.ActivityMain2Binding
import com.example.consumo.databinding.ActivityMainBinding
import com.example.consumo.model.Ciudad
import com.example.consumo.model.ManagerBd

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaCiudades = binding.lista
        val manager = ManagerBd(this)
        //manager.showData()

        val arrayAdapter : ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, manager.showData())
        listaCiudades.adapter = arrayAdapter

        Toast.makeText(this, "Ciudades", Toast.LENGTH_SHORT).show()
    }
}