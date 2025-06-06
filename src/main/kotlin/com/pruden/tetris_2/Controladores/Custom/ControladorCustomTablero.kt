package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.Observables.cargarObservableTablero
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.beans.property.BooleanProperty
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorCustomTablero : ControladorGEN(), Initializable {
    @FXML private lateinit var carrusel: ImageView
    @FXML private lateinit var tableroLabel: Label
    @FXML private lateinit var guardarB: Button

    companion object{
        lateinit var stageCustomTablero : Stage
        lateinit var guardarTablero: BooleanProperty

        val listaNumFilas = intArrayOf(14, 20, 32)
        val listaNumColumnas = intArrayOf(8, 10, 20)
        val listaTamaCelda = intArrayOf(45, 33, 20)

        var tabPosicion = 0

        var cambioDeTAbleroParaTipoPieza = false
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cargarPosicionTablero()
        cargarTableroYTitulo()
        cargarObservableTablero()
    }


    @FXML fun salir() {
        stageCustomTablero.close()
    }


    @FXML fun guardar() {
        crearStage(Stages.ADVERTENCIA_TABLERO)
    }


    @FXML fun siguiente() {
        if (tabPosicion == Listas.LISTA_IMAGENES_DE_TABLEROS.size - 1) {
            tabPosicion = 0
        } else tabPosicion++
        cargarTableroYTitulo()
    }

    @FXML fun anterior() {
        if (tabPosicion == 0) {
            tabPosicion = Listas.LISTA_IMAGENES_DE_TABLEROS.size - 1
        } else tabPosicion--
        cargarTableroYTitulo()
    }

    private fun cargarPosicionTablero(){
        tabPosicion = Globales.FILAS.toString()[0].toString().toInt() - 1
    }

    private fun cargarTableroYTitulo(){
        val tab: Image = Listas.LISTA_IMAGENES_DE_TABLEROS[tabPosicion]
        tableroLabel.text = tab.url.substring(tab.url.lastIndexOf("/") + 1, tab.url.lastIndexOf("."))
        carrusel.image = tab
    }

    override fun setStage(stage: Stage?) {
        stageCustomTablero = stage!!
    }

    override fun setBoton(b: Button?) {}
}