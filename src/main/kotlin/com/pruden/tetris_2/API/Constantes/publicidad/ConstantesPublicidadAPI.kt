package com.pruden.tetris_2.API.Constantes.publicidad

object ConstantesPublicidadAPI {
    val PATH_PUBLICIDAD: String = System.getProperty("serverIp")?.let {
        "http://$it:8082"
    } ?: "http://localhost:8082"

    const val TODOS_ANUNCIOS = "/anuncios"
    const val PATH_CLICK_PUBLICIDAD = "/anuncio/{id}"
}