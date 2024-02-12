package com.example.consumo.model
data class Ciudad(val cod: Int, val nombre: String, val codedep: Int) {
    override fun hashCode(): Int {
        return cod + codedep
    }

}