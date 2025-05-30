package com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.FinDelNivel

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idNivelActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Metodos.BorrarPiezas.objLineasNivel
import com.pruden.tetris_2.Metodos.Cronometro.formatoASegundos
import com.pruden.tetris_2.Metodos.ExperienciaYNiveles.ajusteExpAlTerminarNivel
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.Perder.subirDatosFinDePartida
import com.pruden.tetris_2.Metodos.SubirDatos.subirDatosNivelCompeltado

fun comprobarPasarNivel(){
    if (seHaAlcanzadoElNivelObj()) {
        cambioVariablesAlTerminarNivel()

        if (seCumpleTiempoLineasYPuntuacionObjetivo()) {
            ganarNivelModoCampa()
            subirDatosFinDePartida()
            subirDatosNivelCompeltado()
        } else {
            perderNivelModoCampa()
            jugadorConTodo!!.listaNivelesJugador[idNivelActual -1].sumarIntento()
        }
        ajusteExpAlTerminarNivel()
    }
}

private fun ganarNivelModoCampa(){
    cargarLabelsFinNivel("¡Nivel completado!")
    cPrin.cuentaRegresivaIMG.image = deRutaAImagen("/Imagenes/Logos/marcoCompletado.png")
    ControladorPrincipal.nivelCompletado = true
}
private fun cambioVariablesAlTerminarNivel(){
    ControladorPrincipal.cronometro.parar()
    ControladorPrincipal.timelinePartida.stop()
    ControladorPrincipal.nivelTerminado = true
    ControladorPrincipal.partidaEnCurso = false
}
private fun seHaAlcanzadoElNivelObj(): Boolean{
    val nivelActual: Int = cPrin.labelNivel.text.split("/")[0].toInt()
    return ControladorPrincipal.nivelEnJuego && nivelActual >= ControladorPrincipal.objFasesNivel.split("/")[1].toInt()
}
private fun seCumpleTiempoLineasYPuntuacionObjetivo():Boolean{
    with(cPrin){
        return labelLineas.text.split("/")[0].toInt() >= objLineasNivel.split("/")[1].toInt()
                && formatoASegundos(cronometroLabel.text.split("/")[0]) < formatoASegundos(cronometroLabel.text.split("/")[1])
                && labelPuntuacion.text.split("/")[0].toInt() >= ControladorPrincipal.objPuntuacionBajar.split("/")[1].toInt()
    }
}