package com.pruden.tetris_2.Constantes

import com.pruden.tetris_2.Metodos.ModosDeJuego.Modos.ModoDeJuego

object ModosDeJuego {
    val CLASICO = ModoDeJuego("Clásico",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 10,
        100, false, -1, true, 1, true, 1,false)
    val CLASICO_V2 = ModoDeJuego("Clásico v2",intArrayOf(10, 12, 13, 17, 18, 22, 30), 1500, 10,
        100, false, -1, true, 1, true, 1, false)
    val ALL_IN = ModoDeJuego("All in",IntArray(48) { it }, 1500, 10,
        100, false, -1, true, 2, true, 1, true)
    val ALGEBRA = ModoDeJuego("Algebra",intArrayOf(3, 8, 13, 14, 20, 28), 1800, 5,
        100, true, 4, true, 1, true, 1, false)
    val RAPID_O  = ModoDeJuego("RapidO",intArrayOf(0, 17, 24, 29, 36, 37), 500, 5,
        50, false, -1, true, 0, true,1, true)
    val MEMORY  = ModoDeJuego("Memory",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 10,
        100, false, -1, true, 1, true, 2, false)
    val MEMORY_X  = ModoDeJuego("MemoryX",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 10,
        100, false, -1, true, 1, true, 3, false)
    val MEMORY_Y  = ModoDeJuego("MemoryY",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 10,
        100, false, -1, true, 1, true, 4, false)
}