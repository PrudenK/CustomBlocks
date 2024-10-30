package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcHold
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente1
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente2
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente3
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Metodos.BolsaPiezas.dibujarPiezasSiguientes
import com.pruden.tetris_2.Metodos.DibujarTablero.General.borrarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorCustomTipoTablero: ControladorGEN(), Initializable {
    private lateinit var stage : Stage
    private lateinit var cPrincipal : ControladorPrincipal

    @FXML private lateinit var labelSecundario: Label
    @FXML private lateinit var labelPrincipal: Label
    @FXML private lateinit var imgViewPrincipal: ImageView
    @FXML private lateinit var imgViewSecundarios: ImageView

    private val pClasico = deRutaAImagen("/Imagenes/Tipos_De_Tableros/clasico.jpg")
    private val pVacio = deRutaAImagen("/Imagenes/Tipos_De_Tableros/vacio_principal.jpg")
    private val sClasico = deRutaAImagen("/Imagenes/Tipos_De_Tableros/clasico_secundario.jpg")
    private val sVacio = deRutaAImagen("/Imagenes/Tipos_De_Tableros/vacio_secundario.jpg")

    private lateinit var listaPrincipales : ArrayList<Image>
    private lateinit var listaSecundarios : ArrayList<Image>

    private lateinit var listaNombresPrincipales : ArrayList<String>
    private lateinit var listaNombresSecundarios : ArrayList<String>

    private var tableroPrincipalNum = 0
    private var tableroSecundarioNum = 0

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        incializarArrays()
    }

    @FXML
    private fun guardar() {
        cambiosTipoTablero()


        stage.close()
    }

    @FXML
    private fun volver() {
        stage.close()
    }

    fun cambiosTipoTablero() {
        tipoTableroPrin = tableroPrincipalNum
        tipoTableroSecun = tableroSecundarioNum

        dibujarTableroPrincipal()

        borrarTableroSecundario(gcSiguiente1)
        borrarTableroSecundario(gcSiguiente2)
        borrarTableroSecundario(gcSiguiente3)
        borrarTableroSecundario(gcHold)


        dibujarPiezasSiguientes(-1)
    }


    @FXML
    private fun siguienteSecun() {
        if (tableroSecundarioNum == listaSecundarios.size - 1) {
            tableroSecundarioNum = 0
        } else tableroSecundarioNum++
        imgViewSecundarios.image = listaSecundarios[tableroSecundarioNum]
        labelSecundario.text = listaNombresSecundarios[tableroSecundarioNum]
    }

    @FXML
    private fun atrasSecun() {
        if (tableroSecundarioNum == 0) {
            tableroSecundarioNum =
                listaSecundarios.size - 1
        } else tableroSecundarioNum--
        imgViewSecundarios.image = listaSecundarios[tableroSecundarioNum]
        labelSecundario.text = listaNombresSecundarios[tableroSecundarioNum]
    }

    @FXML
    private fun atrasPrincipal() {
        if (tableroPrincipalNum == 0) {
            tableroPrincipalNum = listaPrincipales.size - 1
        } else tableroPrincipalNum--
        imgViewPrincipal.image = listaPrincipales[tableroPrincipalNum]
        labelPrincipal.text = listaNombresPrincipales[tableroPrincipalNum]
    }

    @FXML
    private fun siguientePrincipal() {
        if (tableroPrincipalNum == listaPrincipales.size - 1) {
            tableroPrincipalNum = 0
        } else tableroPrincipalNum++
        imgViewPrincipal.image = listaPrincipales[tableroPrincipalNum]
        labelPrincipal.text = listaNombresPrincipales[tableroPrincipalNum]
    }


    private fun incializarArrays() {
        listaPrincipales = ArrayList<Image>()
        listaSecundarios = ArrayList<Image>()
        listaNombresPrincipales = ArrayList<String>()
        listaNombresSecundarios = ArrayList<String>()
        listaPrincipales.add(pVacio)
        listaPrincipales.add(pClasico)
        listaSecundarios.add(sVacio)
        listaSecundarios.add(sClasico)
        listaNombresPrincipales.add("Tablero vacío")
        listaNombresPrincipales.add("Tablero clásico")
        listaNombresSecundarios.add("Tablero vacío")
        listaNombresSecundarios.add("Tablero clásico")
        tableroPrincipalNum = tipoTableroPrin
        tableroSecundarioNum = tipoTableroSecun
        imgViewPrincipal.image = listaPrincipales[tableroPrincipalNum]
        imgViewSecundarios.image = listaSecundarios[tableroSecundarioNum]
        labelPrincipal.text = listaNombresPrincipales[tableroPrincipalNum]
        labelSecundario.text = listaNombresSecundarios[tableroSecundarioNum]
    }


    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }

    override fun setBoton(b: Button?) {}

    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
        cPrincipal = principal!!
    }


}