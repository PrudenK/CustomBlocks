package com.pruden.tetris_2.Metodos.ExperienciaYNiveles

object SistemaProgresion {
    private const val BASE = 1200.0
    private const val FACTOR = 2.2

    private fun experienciaParaNivel(nivel: Int): Int {
        return (BASE * Math.pow(nivel.toDouble(), FACTOR)).toInt()
    }

    fun calcularNivelPorXP(xpActual: Int): Int {
        var nivel = 1
        var acumulado = 0
        while (nivel <= 100) {
            acumulado += experienciaParaNivel(nivel)
            if (xpActual < acumulado) break
            nivel++
        }
        return nivel
    }

    fun calcularXPLinea(lineas: Int, modo: String, tipoTablero: Int): Int {
        val xpPorLinea = when (modo) {
            "Clásico" -> 150
            "Clásico v2" -> 200
            "All in" -> 400
            "Álgebra" -> 800
            "RapidO" -> 200
            "Memory" -> 250
            "MemoryX" -> 300
            "MemoryY" -> 300
            "Campaña" -> 100
            "Custom" -> 10
            else -> 10
        }

        val multiplicador = when (tipoTablero) {
            0 -> 0.5
            1 -> 1.0
            2 -> 3.0
            else -> 1.0
        }

        return (lineas * xpPorLinea * multiplicador).toInt()
    }
}
