package com.example.consumo.model

class Constantes {

    // Sirve  para que mis constantes sean globales
    companion object{
        const val NOM_BD = "BdAdso"
        const val VERSION_BD = 7
        const val TABLA = "CREATE TABLE ciudad (cod int, nombre text, codedep int)"
        const val DATATABLA = "SELECT * FROM ciudad"
    }
}