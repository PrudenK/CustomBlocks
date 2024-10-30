package com.pruden.tetris_2.Metodos.Stages

import javafx.animation.Timeline
import javafx.scene.control.Button

data class ClaseStage (
    var vista : String,
    var elemento : Button,
    var ancho : Double,
    var alto : Double,
    var timeline: Timeline?,
    var movX : Int,
    var movY : Int
    )
