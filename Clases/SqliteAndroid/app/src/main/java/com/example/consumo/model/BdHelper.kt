package com.example.consumo.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BdHelper(
    // Extender Clase con Sqlite
    context: Context?
) : SQLiteOpenHelper(context,Constantes.NOM_BD,null,Constantes.VERSION_BD) {
    override fun onCreate(db: SQLiteDatabase?) {
         db?.execSQL(Constantes.TABLA)
         db?.execSQL(Constantes.DATA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ciudad")
        db?.execSQL("DROP TABLE IF EXISTS Data")
        onCreate(db)
    }
}