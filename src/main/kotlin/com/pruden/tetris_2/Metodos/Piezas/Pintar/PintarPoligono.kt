package com.pruden.tetris_2.Metodos.Piezas.Pintar

import javafx.scene.canvas.GraphicsContext
import kotlin.math.cos
import kotlin.math.sin

fun poligono(y: Double, x: Double, nLados: Int, gc : GraphicsContext, tama : Int) {
    val centerX = x + tama / 2.0
    val centerY = y + tama / 2.0
    val radius = (tama - 2) / 2.0
    val xPoints = DoubleArray(nLados)
    val yPoints = DoubleArray(nLados)

    for (i in 0 until nLados) {
        if (nLados == 3) {
            xPoints[i] = centerX + radius * cos(2 * Math.PI * i / nLados - Math.PI / 2)
            yPoints[i] = centerY + radius * sin(2 * Math.PI * i / nLados - Math.PI / 2)
        } else {
            xPoints[i] = centerX + radius * cos(2 * Math.PI * i / nLados)
            yPoints[i] = centerY + radius * sin(2 * Math.PI * i / nLados)
        }
    }
    gc.fillPolygon(xPoints, yPoints, nLados)
}