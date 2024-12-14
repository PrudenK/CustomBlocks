package com.pruden.tetris_2.Metodos.ModoCampa.Dataº

import com.pruden.tetris_2.Controladores.ModoCampa.ControladorModoCampa.Companion.cModoCampa
import com.pruden.tetris_2.Controladores.ModoCampa.ControladorMundos.Companion.cMundo1
import com.pruden.tetris_2.Controladores.ModoCampa.ControladorMundos.Companion.mundoActual
import com.pruden.tetris_2.Metodos.ModoCampa.CargarNivel.cargarStageCargaYNivel
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.scene.image.ImageView

fun cargarAccionesImageViewsNiveles(){
    Platform.runLater{
        for (i in 1 .. 9){
            val imgView = cMundo1.stageMundo1.scene.lookup("#nivel$i") as ImageView
            imgView.setOnMouseClicked { cargarStageCargaYNivel(cMundo1.listaNivelesMundos[mundoActual][i-1], cMundo1.stageMundo1) }
        }
        println(mundoActual)
    }
}

fun cargarAccionesImageViewsMundos(){
    Platform.runLater{
        for (i in 1 .. 9){
            val imgView = cModoCampa.stageModoCampa.scene.lookup("#imgViewMundo$i") as ImageView
            imgView.setOnMouseClicked {abrirMundo(i) }
        }
    }
}
private fun abrirMundo(mundo: Int){
    crearStage(ClaseStage("Vistas/ModoCampa/vista_Mundo1.fxml", cModoCampa.volverB, 600.0, 797.0, null, 0, 0, mundo))
}