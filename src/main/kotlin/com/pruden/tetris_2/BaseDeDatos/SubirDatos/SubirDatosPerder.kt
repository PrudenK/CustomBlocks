package com.pruden.tetris_2.BaseDeDatos.SubirDatos

import com.pruden.tetris_2.Controladores.ControladorPrincipal

fun subirDatosPerder(){
    subirDatosPartida()

    if (ControladorPrincipal.cPrin.labelModo.text.equals("Custom")){
        subirDatosEstaTotalesYCustom("estaCustom")
    }else{
        subirDatosModo()
    }

    subirDatosEstaTotalesYCustom("estaTotales")
    sumarTipoPieza(ControladorPrincipal.piezaActual)
    subirTodoEstaPiezas()
}