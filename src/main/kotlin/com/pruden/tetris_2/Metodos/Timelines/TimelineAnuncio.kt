package com.pruden.tetris_2.Metodos.Timelines

import com.pruden.tetris_2.API.Constantes.publicidad.ApiPublicidad
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
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
    if (jugarOnline && jugadorConTodo!!.suscripcionDelJugador == null) return

    if(jugarOnline){
        if(jugadorConTodo!!.suscripcionDelJugador!!.tipo == -1){
            timeLineAnuncio()
        }else{
            paraTimeLineAnuncios()
        }
    }else{
        timeLineAnuncio()
    }

    println(11111)
}

private fun timeLineAnuncio(){
    CoroutineScope(Dispatchers.IO).launch {
        val anunciosPortatiles = ApiPublicidad.anuncios.filter { it.tipo == 1 }
        timeLineAnuncios?.stop()
        cPrin.imgPublicidad.isVisible = true
        cPrin.nombreAnunciosPC.isVisible = true

        precargarImagen(anunciosPortatiles[indiceActualAnuncio].imagen) { imagen ->
            cPrin.imgPublicidad.image = imagen
        }
        cPrin.nombreAnunciosPC.text = anunciosPortatiles[indiceActualAnuncio].nombre

        timeLineAnuncios =  Timeline(
            KeyFrame(Duration.seconds(5.0), {
                indiceActualAnuncio = (indiceActualAnuncio + 1) % anunciosPortatiles.size
                val anuncio = anunciosPortatiles[indiceActualAnuncio]

                precargarImagen(anuncio.imagen) { imagen ->
                    javafx.application.Platform.runLater {
                        cPrin.imgPublicidad.image = imagen
                    }
                }
                cPrin.nombreAnunciosPC.text = anuncio.nombre
            })
        ).apply {
            cycleCount = Timeline.INDEFINITE
            play()
        }

        //paraTimeLineAnuncios()
    }
}

fun paraTimeLineAnuncios(){ // TODO revisar en suscripciones
    if(jugadorConTodo?.suscripcionDelJugador?.tipo != -1) {
        timeLineAnuncios?.stop()
        cPrin.imgPublicidad.isVisible = false
        cPrin.nombreAnunciosPC.isVisible = false
        cPrin.gifPublicidad.isVisible = false
        cPrin.nombreGif.isVisible = false
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
