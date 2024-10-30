package com.pruden.tetris_2.Metodos.Piezas.Pintar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMANO_CELDA
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcPrincipal
import kotlin.math.cos
import kotlin.math.sin

fun poligono(y: Double, x: Double, n_lados: Int) {
    // Calcular el centro de la celda
    val centerX = x + TAMANO_CELDA / 2.0
    val centerY = y + TAMANO_CELDA / 2.0
    val radius = (TAMANO_CELDA - 2) / 2.0
    val xPoints = DoubleArray(n_lados)
    val yPoints = DoubleArray(n_lados)

    // Calcular las coordenadas de los vértices del polígono
    for (i in 0 until n_lados) {
        if (n_lados == 3) {
            xPoints[i] = centerX + radius * cos(2 * Math.PI * i / n_lados - Math.PI / 2)
            yPoints[i] = centerY + radius * sin(2 * Math.PI * i / n_lados - Math.PI / 2)
        } else {
            xPoints[i] = centerX + radius * cos(2 * Math.PI * i / n_lados)
            yPoints[i] = centerY + radius * sin(2 * Math.PI * i / n_lados)
        }
    }
    gcPrincipal.fillPolygon(xPoints, yPoints, n_lados)
}