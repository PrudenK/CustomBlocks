package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.Constantes.publicidad.ApiPublicidad
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun onClickAnuncio(id: Int) {
    CoroutineScope(Dispatchers.IO).launch {
        ApiPublicidad.publicidadService.onClickAnuncio(id)
    }
}