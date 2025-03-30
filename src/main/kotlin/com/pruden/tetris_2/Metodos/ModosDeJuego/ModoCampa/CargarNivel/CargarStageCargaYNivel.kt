package com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.CargarNivel

import com.pruden.tetris_2.API.ObjsAux.Nivel
import com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa.ControladorModoCampa
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.PantallaDeCarga.nivelModoCampa
import com.pruden.tetris_2.Metodos.Stages.cargarStageCargarNivel
import javafx.stage.Stage

fun cargarStageCargaYNivel(n : Nivel, stage : Stage){
    nivelModoCampa = n

    stage.close()
    ControladorModoCampa.cModoCampa.stageModoCampa.close()

    cargarNivel(n)
    cargarStageCargarNivel(Stage())
}