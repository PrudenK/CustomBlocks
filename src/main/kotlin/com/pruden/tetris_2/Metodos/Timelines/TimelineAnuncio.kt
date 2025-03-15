package com.pruden.tetris_2.Metodos.Timelines

import com.pruden.tetris_2.ApiPublicidad
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.scene.image.Image
import javafx.util.Duration

var indiceActualAnuncio = ApiPublicidad.anuncios.size-1


fun cargarTimeLineAuncios(){
    if (ApiPublicidad.anuncios.isEmpty()) return

    cPrin.imgPublicidad.image = Image(ApiPublicidad.anuncios[indiceActualAnuncio].imagen)

    Timeline(
        KeyFrame(Duration.seconds(5.0), {
            indiceActualAnuncio = (indiceActualAnuncio + 1) % ApiPublicidad.anuncios.size
            val anuncio = ApiPublicidad.anuncios[indiceActualAnuncio]
            cPrin.imgPublicidad.image = Image(anuncio.imagen)
        })
    ).apply {
        cycleCount = Timeline.INDEFINITE
        play()
    }
}