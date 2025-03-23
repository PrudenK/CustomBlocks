package com.pruden.tetris_2.Metodos.ModoCampa.Dataº

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaMundos
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaMundosJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaNiveles
import com.pruden.tetris_2.Controladores.ModoCampa.ControladorModoCampa.Companion.cModoCampa
import com.pruden.tetris_2.Controladores.ModoCampa.ControladorMundos.Companion.cMundo1
import com.pruden.tetris_2.Controladores.ModoCampa.ControladorMundos.Companion.mundoActual
import com.pruden.tetris_2.Metodos.ModoCampa.CargarNivel.cargarStageCargaYNivel
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.scene.effect.ColorAdjust
import javafx.scene.image.Image
import javafx.scene.image.ImageView

fun cargarAccionesImageViewsNiveles(){
    Platform.runLater{
        for (i in 1 .. 9){
            val imgView = cMundo1.stageMundo1.scene.lookup("#nivel$i") as ImageView
            val listaAux = listaNiveles.filter { it.mundo.idMundo == mundoActual+1 }
            imgView.setOnMouseClicked { cargarStageCargaYNivel(listaAux[i-1], cMundo1.stageMundo1) }
        }
        println(mundoActual)
    }
}

fun cargarAccionesImageViewsMundos(){
    Platform.runLater{
        for (i in 1 .. 9){
            val imgView = cModoCampa.stageModoCampa.scene.lookup("#imgViewMundo$i") as ImageView
            val imgViewCadena = cModoCampa.stageModoCampa.scene.lookup("#cadenaMundo$i") as ImageView

            imgView.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${listaMundos[i-1].imagen}", true)

            val mundoJugador = listaMundosJugador[i-1]

            if(!mundoJugador.completado){
                val grayscale = ColorAdjust().apply {
                    saturation = -1.0
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
    crearStage(ClaseStage("Vistas/ModoCampa/vista_Mundo1.fxml", cModoCampa.volverB, 711.0, 809.0, null, 0, 0, mundo))
}