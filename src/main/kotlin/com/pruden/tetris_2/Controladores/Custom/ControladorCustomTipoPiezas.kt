package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
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

    private val pieza0 : Image = deRutaAImagen("/Imagenes/Tipo_De_Pieza/Circulo.png")
    private val pieza3 = deRutaAImagen("/Imagenes/Tipo_De_Pieza/Triangulo.png")
    private val pieza4 = deRutaAImagen("/Imagenes/Tipo_De_Pieza/Cuadrado.png")
    private val pieza5 = deRutaAImagen("/Imagenes/Tipo_De_Pieza/Pentagono.png")
    private val pieza6 = deRutaAImagen("/Imagenes/Tipo_De_Pieza/Hexagono.png")

    private var listaPiezasIMG: ArrayList<Image> = ArrayList<Image>()
    private var mapaPiezasIMG: HashMap<Int, Image> = HashMap<Int, Image>()
    private var posicionLista = 0
    private val cambio = false

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        iniciarListas()
    }


    @FXML private fun volver() {
        stage.close()
    }

    @FXML private fun guardar() {
        cambioTipoPieza()
        stage.close()
    }

    @FXML private fun siguiente() {
        if (posicionLista != listaPiezasIMG.size - 1) {
            posicionLista++
        } else posicionLista = 0
        ponerNombreLabel()
    }

    @FXML private fun atras() {
        if (posicionLista != 0) {
            posicionLista--
        } else posicionLista = listaPiezasIMG.size - 1
        ponerNombreLabel()
    }


    private fun cambioTipoPieza() {
        tipoPieza = (obtenerClavePorValor(listaPiezasIMG[posicionLista]))


        if (!cambioDeTAbleroParaTipoPieza){
            for (i in 0 until FILAS) {
                for (j in 0 until COLUMNAS) {
                    pintarCasilla(FONDO,i.toDouble(), j.toDouble())
                }
            }

            for (j in FILAS downTo 0) {
                pintarMatriz(j, -10)
            }

            dibujarPiezasSiguientes(-1)
        }


    }

    private fun obtenerClavePorValor(valor: Any): Int {
        var clave = 4
        for ((key, value) in mapaPiezasIMG.entries) {
            if (value == valor) {
                clave = key
                break
            }
        }
        return clave
    }

    private fun iniciarListas() {
        listaPiezasIMG =ArrayList<Image>()
        mapaPiezasIMG = HashMap<Int, Image>()
        listaPiezasIMG.add(pieza0)
        listaPiezasIMG.add(pieza3)
        listaPiezasIMG.add(pieza4)
        listaPiezasIMG.add(pieza5)
        listaPiezasIMG.add(pieza6)
        mapaPiezasIMG[0] = listaPiezasIMG[0]
        mapaPiezasIMG[3] = listaPiezasIMG[1]
        mapaPiezasIMG[4] = listaPiezasIMG[2]
        mapaPiezasIMG[5] = listaPiezasIMG[3]
        mapaPiezasIMG[6] = listaPiezasIMG[4]
        posicionLista = listaPiezasIMG.indexOf(mapaPiezasIMG[tipoPieza])
        ponerNombreLabel()
    }

    private fun ponerNombreLabel() {
        imgViewTiposPieza.image = listaPiezasIMG[posicionLista];
        labelNombreTipoPieza.text = (listaPiezasIMG[posicionLista].url.substring(listaPiezasIMG[posicionLista].
        url.lastIndexOf("/")+1, listaPiezasIMG[posicionLista].url.lastIndexOf(".")));
    }

    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }

    override fun setBoton(b: Button?) {}
}