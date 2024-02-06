package com.example.ejemplobd.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

data class ManangerBd(val context: Context) {
    lateinit var bd: SQLiteDatabase

    var bdHelper = BdHelper(context) // Llamando conexion de la base de datos





    //metodo para abrir en bd modo escritura
    fun openBdWr(){

        bd= bdHelper.writableDatabase
    }




 //   abre base de datos en modo lectura
    fun openBdRd(){
        bd= bdHelper.readableDatabase
    }




    fun insertData(): Long {
        openBdWr()
        val contenedor = ContentValues()
        contenedor.put("cod", 2)

        contenedor.put("nombre", "Zule")
        contenedor.put("codedep", 15)
        // llama al método insert
        val result = bd.insert("ciudad", null, contenedor)
        bd.close() // cierra la base de datos después de la operación
        return result
    }


}