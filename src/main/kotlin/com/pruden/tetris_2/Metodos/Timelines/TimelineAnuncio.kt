package com.pruden.tetris_2.Metodos.Timelines

import com.pruden.tetris_2.API.Constantes.publicidad.ApiPublicidad
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.suscripcionDelJugador
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.scene.image.Image
import javafx.util.Duration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var indiceActualAnuncio = ApiPublicidad.anuncios.size-1
var timeLineAnuncios: Timeline? = null

fun cargarTimeLineAuncios() {
    if (ApiPublicidad.anuncios.isEmpty()) return

    CoroutineScope(Dispatchers.IO).launch {
        while (suscripcionDelJugador == null) {
            delay(50)
        }

        precargarImagen(ApiPublicidad.anuncios[indiceActualAnuncio].imagen) { imagen ->
            cPrin.imgPublicidad.image = imagen
        }

        timeLineAnuncios =  Timeline(
            KeyFrame(Duration.seconds(5.0), {
                indiceActualAnuncio = (indiceActualAnuncio + 1) % ApiPublicidad.anuncios.size
                val anuncio = ApiPublicidad.anuncios[indiceActualAnuncio]

                precargarImagen(anuncio.imagen) { imagen ->
                    javafx.application.Platform.runLater {
                        cPrin.imgPublicidad.image = imagen
                    }
                }
            })
        ).apply {
            cycleCount = Timeline.INDEFINITE
            play()
        }

        paraTimeLineAnuncios()
    }
}

fun paraTimeLineAnuncios(){
    if(suscripcionDelJugador!!.tipo != -1) {
        timeLineAnuncios!!.stop()
        cPrin.imgPublicidad.isVisible = false
    }
}

private fun precargarImagen(url: String, onImageLoaded: (Image) -> Unit) {
    Thread {
        val imagen = Image(url, true)
        while (!imagen.progressProperty().get().isNaN() && imagen.progressProperty().get() < 1) {
            Thread.sleep(50)
        }
        javafx.application.Platform.runLater { onImageLoaded(imagen) }
    }.start()
}
