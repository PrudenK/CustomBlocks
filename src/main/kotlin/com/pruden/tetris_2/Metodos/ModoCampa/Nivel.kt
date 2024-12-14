package com.pruden.tetris_2.Metodos.ModoCampa

data class Nivel(
    val nombre: String,
    val piezasDisponiblesPosiciones : IntArray,
    val tiempoCaidaInicial : Int,
    val lineasParaAumento : Int,
    val saltoDeTiempoPorLineas: Int,
    val limiteRotacionesB : Boolean,
    val limiteRotacionesNum: Int,
    val holdActivoNivel: Boolean,
    val tablero: Int,
    val siguientesDisponibles: Boolean,
    val tipoTablero: Int,
    val dash: Boolean,
    val puntuacionObj : Int,
    val tiempoObj: String,
    val lineasObj: Int,
    val numFases: Int
) {
    fun objetivosTxt():String{
        return "$puntuacionObj puntos y $lineasObj lineas en menos de ${tiempoObj.substring(1)}"
    }
    fun holdTxt():String {
        return if (holdActivoNivel) "Activo" else "Desactivado"
    }

    fun tableroTxt():String{
        return if (tablero == 0) "12x8" else if(tablero == 1) "18x10" else "30x20"
    }

    fun limiteRotaciones(): String{
        return if (limiteRotacionesB) limiteRotacionesNum.toString() else "Sin límite"
    }

    fun siguientesPiezas():String{
        return if (siguientesDisponibles) "Disponibles" else "No disponible"
    }

    private val listaTablero = listOf("Vacío", "Clásico", "Memory", "MemoryX", "MemoryY")
    fun tipoTablero():String{
        return listaTablero[tipoTablero]
    }

    fun dashDisponible():String{
        return if (dash) "Disponible" else "No disponible"
    }
}