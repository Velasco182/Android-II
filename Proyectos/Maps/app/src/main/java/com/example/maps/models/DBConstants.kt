package com.example.maps.models

class DBConstants {

    //Necesario para que las constantres sean globales
    companion object{
        const val NOM_BD = "popayanDB"
        const val VERSION_BD = 7
        //const val TABLA = "Create table ciudad (cod int, nombre text, codedep int)"
        const val DATA = "CREATE TABLE data (lat text, lng text)"
    }

}