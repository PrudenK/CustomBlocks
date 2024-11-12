package com.pruden.tetris_2.Metodos.ModoCampa.CargarNivel

import com.pruden.tetris_2.Controladores.ModoCampa.ControladorModoCampa
import com.pruden.tetris_2.Metodos.ModoCampa.Nivel
import com.pruden.tetris_2.Metodos.ModoCampa.PantallaDeCarga.nivel
import com.pruden.tetris_2.Metodos.Stages.cargarStageCargarNivel
import javafx.stage.Stage

fun cargarStageCargaYNivel(n : Nivel, stage : Stage){
    nivel = n

    stage.close()
    ControladorModoCampa.cModoCampa.stageModoCampa.close()

    cargarNivel(n)
    cargarStageCargarNivel(Stage())
}