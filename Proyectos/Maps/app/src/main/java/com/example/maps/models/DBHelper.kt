package com.example.maps.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    //Implementar metodos de DBHelper con alt+enter
    //Extender la clase de SQLite
    context: Context
): SQLiteOpenHelper(context, DBConstants.NOM_BD, null, DBConstants.VERSION_BD) {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
        //db?.execSQL(DBConstants.TABLA)
        db?.execSQL(DBConstants.DATA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
        db?.execSQL("DROP TABLE IF EXISTS data")
        onCreate(db)
    }


}