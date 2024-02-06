package com.example.ejemplobd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejemplobd.model.BdHelper
import com.example.ejemplobd.model.ManangerBd


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //instanciamos la clase bd helper
    /*val bdHelper = BdHelper (this )
        val db = bdHelper.writableDatabase // Abro mi db en mode escritura
        Toast.makeText(this, "Base de datos Creada", Toast.LENGTH_SHORT).show()
        db.close() // cierro la base de datos
*/


            val manager = ManangerBd(this)
        manager.insertData()
        Toast.makeText(this, "Base de datos Creada", Toast.LENGTH_SHORT).show()


    }



}



