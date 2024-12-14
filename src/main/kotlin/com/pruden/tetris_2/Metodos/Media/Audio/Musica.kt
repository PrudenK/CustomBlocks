package com.pruden.tetris_2.Metodos.Media.Audio

import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer

lateinit var musicaJuego: MediaPlayer

fun musicaPartida(pathAudio: String?) {
    val media = Media(pathAudio)
    println(media)
    musicaJuego = MediaPlayer(media)



    musicaJuego.cycleCount = MediaPlayer.INDEFINITE
    musicaJuego.volume = 0.0
    musicaJuego.play()
}
