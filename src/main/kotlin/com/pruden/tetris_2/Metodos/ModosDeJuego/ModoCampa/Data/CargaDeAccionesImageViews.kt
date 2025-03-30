package com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.Dataº

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idNivelActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa.ControladorModoCampa.Companion.cModoCampa
import com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa.ControladorMundos.Companion.cMundo1
import com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa.ControladorMundos.Companion.mundoActual
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.CargarNivel.cargarStageCargaYNivel
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.scene.effect.ColorAdjust
import javafx.scene.image.Image
import javafx.scene.image.ImageView

fun cargarAccionesImageViewsNiveles(){
    Platform.runLater{
        val listaAux = jugadorConTodo.listaNiveles.filter { it.mundo.idMundo == mundoActual+1 }
        val listaAuxNivelJugador = jugadorConTodo.listaNivelesJugador.filter { it.idMundo == mundoActual+1}

        for (i in 1 .. 9){
            val imgView = cMundo1.stageMundo1.scene.lookup("#nivel$i") as ImageView
            val imgViewCadena = cMundo1.stageMundo1.scene.lookup("#cadenaNivel$i") as ImageView


            val nivelJugador = listaAuxNivelJugador[i-1]

            if(!nivelJugador.completado){
                val grayscale = ColorAdjust().apply {
                    saturation = -1.0
                }
                imgView.effect = grayscale
            }

            if(!nivelJugador.desbloqueado){
                imgViewCadena.image = Image(ConstantesCustomAPI.IMAGEN_CADENA, true)
            }else{
                imgViewCadena.setOnMouseClicked {
                    cargarStageCargaYNivel(listaAux[i-1], cMundo1.stageMundo1)
                    idNivelActual = listaAux[i-1].idNivel
                }
                imgViewCadena.image = null
            }


        }
        println(mundoActual)
    }
}

fun cargarAccionesImageViewsMundos(){
    Platform.runLater{
        for (i in 1 .. 9){
            val imgView = cModoCampa.stageModoCampa.scene.lookup("#imgViewMundo$i") as ImageView
            val imgViewCadena = cModoCampa.stageModoCampa.scene.lookup("#cadenaMundo$i") as ImageView

            imgView.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${jugadorConTodo.listaMundos[i-1].imagen}", true)

            val mundoJugador =  jugadorConTodo.listaMundosJugador[i-1]


            val listaNivelesJugadorDelMundo = jugadorConTodo.listaNivelesJugador.filter { it.idMundo == i && it.completado}

            if(!mundoJugador.completado){
                val grayscale = ColorAdjust().apply {
                    saturation = -1.0 + (listaNivelesJugadorDelMundo.size.toDouble() / 9)
                }
                imgView.effect = grayscale
            }

            if(!mundoJugador.desbloqueado){
                imgViewCadena.image = Image(ConstantesCustomAPI.IMAGEN_CADENA, true)
            }else{
                imgViewCadena.setOnMouseClicked {abrirMundo(i) }
                imgViewCadena.image = null
            }
        }
    }
}
private fun abrirMundo(mundo: Int){
    crearStage(ClaseStage("Vistas/ModosDeJuego/ModoCampa/vista_Mundo1.fxml", cModoCampa.volverB, 711.0, 809.0, null, 0, 0, mundo))
}