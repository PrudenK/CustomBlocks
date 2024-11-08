package com.pruden.tetris_2.Metodos.Cronometro

fun segundosAFormato(secs : Int) : String{
    return String.format("%02d:%02d:%02d", secs / 3600, (secs % 3600) / 60, secs % 60)
}

fun formatoASegundos(formato : String) : Int{
    val p = formato.split(":")
    return (p[0].toInt() * 3600) + (p[1].toInt() * 60) + p[2].toInt()
}