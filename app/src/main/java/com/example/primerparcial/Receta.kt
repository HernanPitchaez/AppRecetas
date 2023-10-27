package com.example.primerparcial

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Receta (
    val id:Int,
    val nombre: String,
    val dificultad: Dificultad,
    val pais: Pais,
    val plato: String,
    val ingredientes: String
):Parcelable

enum class Pais {
    ARGENTINA,
    BRASIL,
    ECUADOR,
    COLOMBIA,
    MEXICO,
    PARAGUAY
}

enum class Dificultad {
    BAJA,
    MEDIA,
    ALTA
}