package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.API.Constantes.publicidad.ApiPublicidad
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun obtenerAnuncios() {
    CoroutineScope(Dispatchers.IO).launch{
        ApiPublicidad.anuncios = ApiPublicidad.publicidadService.getAnuncios()
    }
}