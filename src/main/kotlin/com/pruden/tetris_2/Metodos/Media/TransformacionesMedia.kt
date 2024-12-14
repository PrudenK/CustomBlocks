package com.pruden.tetris_2.Metodos.Media

import javafx.scene.image.Image

fun deRutaAAudio(path: String): String? {
    return object {}.javaClass.getResource(path)?.toExternalForm()
}

fun deRutaAImagen(path: String): Image {
    return Image(object {}.javaClass.getResource(path)?.toString())
}