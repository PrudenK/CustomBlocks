package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoPieza
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.cambioDeTAbleroParaTipoPieza
import com.pruden.tetris_2.Metodos.BolsaPiezas.dibujarPiezasSiguientes
import com.pruden.tetris_2.Metodos.Matriz.pintarMatriz
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasilla
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorCustomTipoPiezas : ControladorGEN(), Initializable {
    @FXML private lateinit var labelNombreTipoPieza: Label
    @FXML private lateinit var imgViewTiposPieza: ImageView
    private lateinit var stage : Stage

    private var posicionLista = 0

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        iniciarListas()
    }


    @FXML fun volver() {
        stage.close()
    }

    @FXML fun guardar() {
        cambioTipoPieza()
        stage.close()
    }

    @FXML fun siguiente() {
        if (posicionLista != Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS.size - 1) {
            posicionLista++
        } else posicionLista = 0
        ponerNombreLabel()
    }

    @FXML fun atras() {
        if (posicionLista != 0) {
            posicionLista--
        } else posicionLista = Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS.size - 1
        ponerNombreLabel()
    }


    private fun cambioTipoPieza() {
        tipoPieza = (obtenerClavePorValor(Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS[posicionLista]))


        if (!cambioDeTAbleroParaTipoPieza){
            for (i in 0 until Globales.FILAS) {
                for (j in 0 until Globales.COLUMNAS) {
                    pintarCasilla(FONDO,i.toDouble(), j.toDouble())
                }
            }

            for (j in Globales.FILAS downTo 0) {
                pintarMatriz(j, -10)
            }

            dibujarPiezasSiguientes(-1)
        }
    }

    private fun obtenerClavePorValor(valor: Any): Int {
        var clave = 4
        for ((key, value) in Listas.MAPA_TIPO_PIEZAS_IMG.entries) {
            if (value == valor) {
                clave = key
                break
            }
        }
        return clave
    }

    private fun iniciarListas() {
        posicionLista = Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS.indexOf(Listas.MAPA_TIPO_PIEZAS_IMG[tipoPieza])
        ponerNombreLabel()
    }

    private fun ponerNombreLabel() {
        imgViewTiposPieza.image = Listas.LISTA_IMAGENES_TIPO_DE_PIEZAS[posicionLista];
        labelNombreTipoPieza.text = Listas.MAPA_TIPO_PIEZAS_NOMBRES[posicionLista]
    }

    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }

    override fun setBoton(b: Button?) {}
}