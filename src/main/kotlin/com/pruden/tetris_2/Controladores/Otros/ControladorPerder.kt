package com.pruden.tetris_2.Controladores.Otros

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
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
    private lateinit var cPrincipal: ControladorPrincipal

    @FXML private fun otra(){
        cPrincipal.reiniciarPartida()
        stage.close()
    }

    @FXML private fun cerrar(){
        stage.close()
    }

    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }

    override fun setBoton(b: Button?) {}

    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
        cPrincipal = principal!!
        iniciarLabels()
        musicaPerder()
        partidaEnCurso = false
    }

    private fun iniciarLabels(){
        nivel.text = cPrincipal.labelNivel.text
        puntuacion.text = cPrincipal.labelPuntuacion.text
        lineas.text = cPrincipal.labelLineas.text
    }
    private fun musicaPerder(){
        efectoSonido("/Musica/Efectos/sonidoPerder.mp3")
    }

}