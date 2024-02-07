package com.example.consumo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.consumo.databinding.ActivityMainBinding
import com.example.consumo.model.ManagerBd

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnGuardar = binding.btnGuardar

        btnGuardar.setOnClickListener {
            val cod = binding.camp1.text.toString().toInt()
            val nombre = binding.camp2.text.toString()
            val codedep = binding.camp3.text.toString().toInt()

            val manager = ManagerBd(this)
            manager.insertData(cod, nombre, codedep)
            Toast.makeText(this, "Base de Datos Creada", Toast.LENGTH_SHORT).show()
        }
    }
}


