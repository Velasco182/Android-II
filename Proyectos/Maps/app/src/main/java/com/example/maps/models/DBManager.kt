package com.example.maps.models

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

data class DBManager(val context: Context) {

    lateinit var db: SQLiteDatabase

    //llamamos la conexión con la DB
    val dbhelper = DBHelper(context)

    ///metodo para abrir la DB en modo escritura
    fun openDBW(){
        db = dbhelper.writableDatabase
    }
    ///metodo para abrir la DB en modo lectura
    fun openDBR(){
        db = dbhelper.readableDatabase
    }

    fun insertData(lat: String, lng: String): Long{

        openDBW()//Abrir la db en modo escritura
        ///Creamos un contenedor de valores para insertar data
        val contenedor = ContentValues()
        contenedor.put("lat", lat)
        contenedor.put("lng", lng)

        //llamamos al metodo de insertar
        val result = db.insert("data", null, contenedor)

        return result
    }

}