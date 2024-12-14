package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
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

    private val tab1 = deRutaAImagen("/Imagenes/Tableros/Tablero_12x8.jpg")
    private val tab2 = deRutaAImagen("/Imagenes/Tableros/Tablero_18x10.jpg")
    private val tab3 = deRutaAImagen("/Imagenes/Tableros/Tablero_30x20.jpg")

    private val listaTableros = ArrayList<Image>()



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
        iniciarListaTablero()
        cargarPosicionTablero()
        cargarTableroYTitulo()
        cargarObservableTablero()
    }


    @FXML private fun salir() {
        stageCustomTablero.close()
    }


    @FXML private fun guardar() {
        crearStage(ClaseStage("Vistas/Advertencias/vista_Advertencia_Tablero.fxml", guardarB, 370.0, 210.0, null, 0, 0))
    }


    @FXML private fun siguiente() {
        if (tabPosicion == listaTableros.size - 1) {
            tabPosicion = 0
        } else tabPosicion++
        cargarTableroYTitulo()
    }

    @FXML private fun anterior() {
        if (tabPosicion == 0) {
            tabPosicion = listaTableros.size - 1
        } else tabPosicion--
        cargarTableroYTitulo()
    }

    private fun iniciarListaTablero() {
        listaTableros.add(tab1)
        listaTableros.add(tab2)
        listaTableros.add(tab3)
    }

    private fun cargarPosicionTablero(){
        tabPosicion = FILAS.toString()[0].toString().toInt() - 1
    }

    private fun cargarTableroYTitulo(){
        val tab: Image = listaTableros[tabPosicion]
        tableroLabel.text = tab.url.substring(tab.url.lastIndexOf("/") + 1, tab.url.lastIndexOf("."))
        carrusel.image = tab
    }

    override fun setStage(stage: Stage?) {
        stageCustomTablero = stage!!
    }

    override fun setBoton(b: Button?) {}
}