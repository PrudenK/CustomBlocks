package com.pruden.tetris_2.Controladores.Otros

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage


class ControladorPerder : ControladorGEN() {
    @FXML private lateinit var nivel: Label
    @FXML private lateinit var puntuacion: Label
    @FXML private lateinit var lineas: Label

    private lateinit var stage: Stage

    @FXML fun otra(){
        cPrin.partdiaNueva()
        stage.close()
    }

    @FXML fun cerrar(){
        stage.close()
    }

    override fun setStage(stage: Stage?) {
        this.stage = stage!!
        iniciarLabels()
        musicaPerder()
        partidaEnCurso = false
    }

    override fun setBoton(b: Button?) {}


    private fun iniciarLabels(){
        val (nivelC, puntuacionC, lineasC) = when {
            ControladorPrincipal.partidaPVPenCurso && ControladorPrincipal.eresHostPVP -> Triple(
                cPrin.nivelHostLabel, cPrin.puntuacionHostLabel, cPrin.lineasHostLabel)

            ControladorPrincipal.partidaPVPenCurso && !ControladorPrincipal.eresHostPVP -> Triple(
                cPrin.nivelVisiLabel, cPrin.puntuacionVisiLabel, cPrin.lineasVisiLabel)

            else -> Triple(cPrin.labelNivel, cPrin.labelPuntuacion, cPrin.labelLineas)
        }


        nivel.text = nivelC.text
        puntuacion.text = puntuacionC.text
        lineas.text = lineasC.text
    }
    private fun musicaPerder(){
        efectoSonido("/Musica/Efectos/sonidoPerder.mp3")
    }
}