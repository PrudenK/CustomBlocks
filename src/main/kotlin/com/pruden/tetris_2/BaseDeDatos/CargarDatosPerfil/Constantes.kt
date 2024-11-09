package com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil

import com.pruden.tetris_2.Piezas.*

val listaModos = listOf("Clásico", "Clásico v2", "All in", "Álgebra", "RapidO", "Memory", "MemoryX", "MemoryY")

val listaModosConTodos = listOf("Clásico", "Clásico v2", "All in", "Álgebra", "RapidO", "Memory", "MemoryX", "MemoryY", "Todos")

val listaOrdenar = listOf("Fecha", "Nivel", "Lineas", "Puntuación", "Tiempo")

val listaModosEsta = listOf("estaClasico", "estaClasicoV2", "estaAllIn", "estaAlgebra", "estaRapidO",
    "estaMemory", "estaMemoryX", "estaMemoryY")

val nombresPiezas = listOf(
    "numO", "numI", "numL", "numZ", "numJ", "numS", "numT", "numP", "numX", "numU", "numLv2",
    "numW", "numTv2", "numZv2", "numXv2", "numLv3", "numF", "numOv2", "numSv2", "numB", "numY",
    "numK", "numIv2", "numC", "numOv3", "numV", "numH", "numIv3", "numYv2", "numOv4", "numJv2", "numA"
)

val nombresPiezasYTotal = listOf(
    "numO", "numI", "numL", "numZ", "numJ", "numS", "numT", "numP", "numX", "numU", "numLv2",
    "numW", "numTv2", "numZv2", "numXv2", "numLv3", "numF", "numOv2", "numSv2", "numB", "numY",
    "numK", "numIv2", "numC", "numOv3", "numV", "numH", "numIv3", "numYv2", "numOv4", "numJv2", "numA", "total"
)

val listaInstancias = listOf(
    Pieza_O::class, Pieza_I::class, Pieza_L::class, Pieza_Z::class, Pieza_J::class, Pieza_S::class, Pieza_T::class,
    Pieza_P::class, Pieza_X::class, Pieza_U::class, Pieza_L_v2::class, Pieza_W::class, Pieza_T_v2::class, Pieza_Z_v2::class,
    Pieza_X_v2::class, Pieza_L_v3::class, Pieza_F::class, Pieza_O_v2::class, Pieza_S_v2::class, Pieza_B::class, Pieza_Y::class,
    Pieza_K::class, Pieza_I_v2::class, Pieza_C::class, Pieza_O_v3::class, Pieza_V::class, Pieza_H::class, Pieza_I_v3::class,
    Pieza_Y_v2::class, Pieza_O_v4::class, Pieza_J_v2::class, Pieza_A::class
)