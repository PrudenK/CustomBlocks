package com.pruden.tetris_2.Metodos.Media.Audio

import com.pruden.tetris_2.Metodos.Media.deRutaAAudio
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer


lateinit var efectoSonidoMP : MediaPlayer
var volumenEfectos : Double = 0.0

fun efectoSonido(rutaAudio : String){
    Thread {
        val pathAudio = deRutaAAudio(rutaAudio)
        val media = Media(pathAudio);
        efectoSonidoMP = MediaPlayer(media);
        efectoSonidoMP.volume = volumenEfectos
        efectoSonidoMP.play();
    }.start()
}
