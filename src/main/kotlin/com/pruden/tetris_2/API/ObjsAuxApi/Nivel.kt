package com.pruden.tetris_2.API.ObjsAuxApi

data class Nivel(
    val idNivel: Int,
    val mundo: Mundo,
    val nombre: String,
    val arrayPiezas: String,
    val tiempoCaidaInicial: Int,
    val lienasParaAumentar: Int,
    val saltoDeTiempoPorLineas: Int,
    val limiteRotacionesB: Boolean,
    val limiteRotacionesNum: Int,
    val holdActivado: Boolean,
    val tablero: Int,
    val siguientesDisponibles: Int,
    val tipoTablero: Int,
    val dash: Boolean,
    val puntuacionObj: Int,
    val tiempoObj: String,
    val lineasObj: Int,
    val numFases: Int,
    val imagen: String
){
    fun getMundo() = mundo.idMundo
    fun getPiezas() = arrayPiezas.split("_").map { it.toInt() }

    fun objetivosTxt():String{
        return "$puntuacionObj puntos y $lineasObj lineas en menos de ${tiempoObj.substring(1)}"
    }
    fun holdTxt():String {
        return if (holdActivado) "Activo" else "Desactivado"
    }

    fun tableroTxt():String{
        return if (tablero == 0) "12x8" else if(tablero == 1) "18x10" else "30x20"
    }

    fun limiteRotaciones(): String{
        return if (limiteRotacionesB) limiteRotacionesNum.toString() else "Sin"
    }

    fun siguientesPiezas():String{
        return if (siguientesDisponibles == 1) "Disponibles" else "No disponible"
    }

    fun tipoTablero():String{
        return listOf("Vacío", "Clásico", "Memory", "MemoryX", "MemoryY")[tipoTablero]
    }

    fun dashDisponible():String{
        return if (dash) "Disponible" else "No disponible"
    }
}
