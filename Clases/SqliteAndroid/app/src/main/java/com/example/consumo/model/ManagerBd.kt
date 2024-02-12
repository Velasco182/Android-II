package com.example.consumo.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.core.database.getIntOrNull

data class ManagerBd(val context: Context) {

    lateinit var bd: SQLiteDatabase

    val bdHelper = BdHelper(context)// llamando a mi conexion

    // metodo para abrir la base de datos en modo escritura
    fun openBdWr() {
        bd = bdHelper.writableDatabase
    }

    // metodo para abrir la base de datos en modo lectura
    fun openBdRd() {
        bd = bdHelper.readableDatabase
    }

    fun insertData(cod: Int, nombre: String, codedep: Int): Long {
        openBdWr()// abrir bd en modo escritura
        //Creo contenedor de valores para insertar data
        val contenedor = ContentValues()
        contenedor.put("cod", cod)
        contenedor.put("nombre", nombre)
        contenedor.put("codedep", codedep)
        //llamo metodo insert

        val resul = bd.insert("ciudad", null, contenedor)

        return resul
    }

    fun showData(): ArrayList<Ciudad> {
        // abrir bd en modo escritura
        openBdRd()
        //lista de ciudades
        val ciudadArray = ArrayList<Ciudad>()
        //Cramos el cursor
        val cursor = bd.rawQuery(Constantes.DATATABLA, null)

        if(cursor.moveToFirst()){
            do {
                ///Campos de la base de datos que se van a mostrar
                val cod = cursor.getColumnIndex("cod")
                val nombre = cursor.getColumnIndex("nombre")
                val codedep = cursor.getColumnIndex("codedep")

                //Obtener valores condicionado a not null
                val id = cursor.getString(cod) ?: " "
                val nom = cursor.getString(nombre) ?: " "
                val co = cursor.getString(codedep) ?: " "

                //Añadimos los valores obtenidos del cursor al objeto ciudadArray
                val ciudad = Ciudad(id.toInt(), nom, co.toInt())
                //agrego ciudad al array
                ciudadArray.add(ciudad)
                //el ciclo se hace hasta que el cursor vaya hasta el siguiente elemento del arreglo
            }while(cursor.moveToNext())
        }
        //retornamos el arreglo para llenar el listView
        return ciudadArray
    }
}


