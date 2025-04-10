package com.pruden.tetris_2.API.ObjsAuxApi

data class Anuncio(
    var id: Int,
    var imagen: String,
    var link: String,
    var vecesclickado: Int,
    var tipo: TipoAnuncio,
    var nombre: String
)
