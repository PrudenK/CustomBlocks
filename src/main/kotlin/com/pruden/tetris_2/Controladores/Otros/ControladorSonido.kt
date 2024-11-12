package com.pruden.tetris_2.Controladores.Otros

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.Media.Audio.musicaJuego
import com.pruden.tetris_2.Metodos.Media.Audio.volumenEfectos
import javafx.beans.value.ObservableValue
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorSonido : ControladorGEN(), Initializable {
    @FXML private lateinit var barraMusica: Slider
    @FXML private lateinit var barraEfectosSonido: Slider
    @FXML private lateinit var porcentajeMusica: Label
    @FXML private lateinit var porcentajeEfectos: Label


    private lateinit var stageSonido: Stage


    @FXML
    private fun atras() {
        stageSonido.close()
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        barraMusica.value = musicaJuego.volume * 100
        barraEfectosSonido.value = volumenEfectos * 100

        porcentajeMusica.text = String.format("%.0f%%", barraMusica.value)
        porcentajeEfectos.text = String.format("%.0f%%", barraEfectosSonido.value)

        barraMusica.valueProperty().addListener { _: ObservableValue<out Number>?, _: Number?, newValue: Number ->
            val volumen = newValue.toDouble() / 100.0
            musicaJuego.volume = volumen
            porcentajeMusica.text = String.format("%.0f%%", newValue.toDouble())
        }

        barraEfectosSonido.valueProperty().addListener { _: ObservableValue<out Number>?, _: Number?, newValue: Number ->
            val volumen = newValue.toDouble() / 100.0
            volumenEfectos = volumen
            porcentajeEfectos.text = String.format("%.0f%%", newValue.toDouble())
        }

    }


    override fun setStage(stage: Stage?) {
        stageSonido = stage!!
    }

    override fun setBoton(b: Button?) {
    }
}