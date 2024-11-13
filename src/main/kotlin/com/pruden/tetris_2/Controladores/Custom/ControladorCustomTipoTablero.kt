package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Controladores.Advertencias.ControladorAdvertenciaTipoTablero2.Companion.haGuardadoAdvertencia
import com.pruden.tetris_2.Controladores.Advertencias.ControladorAdvertenciaTipoTablero2.Companion.mensajeAdvertenciaTT2
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.Observables.cargarObservableTipoTablero
import com.pruden.tetris_2.Metodos.Observables.cargarObservableTipoTableroSinReiniciar
import com.pruden.tetris_2.Metodos.Observables.cargarObservableTipoTableroSinReiniciarSecundario
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

class ControladorCustomTipoTablero: ControladorGEN(), Initializable {
    private lateinit var elemento : Button

    @FXML private lateinit var labelSecundario: Label
    @FXML private lateinit var labelPrincipal: Label
    @FXML private lateinit var imgViewPrincipal: ImageView
    @FXML private lateinit var imgViewSecundarios: ImageView

    private val pClasico = deRutaAImagen("/Imagenes/Tipos_De_Tableros/clasico.jpg")
    private val pVacio = deRutaAImagen("/Imagenes/Tipos_De_Tableros/vacio_principal.jpg")
    private val pMemory = deRutaAImagen("/Imagenes/Tipos_De_Tableros/Memory.jpg")
    private val pMemoryX = deRutaAImagen("/Imagenes/Tipos_De_Tableros/MemoryX.jpg")
    private val pMemoryY = deRutaAImagen("/Imagenes/Tipos_De_Tableros/MemoryY.jpg")

    private val sClasico = deRutaAImagen("/Imagenes/Tipos_De_Tableros/clasico_secundario.jpg")
    private val sVacio = deRutaAImagen("/Imagenes/Tipos_De_Tableros/vacio_secundario.jpg")

    private lateinit var listaPrincipales : ArrayList<Image>
    private lateinit var listaSecundarios : ArrayList<Image>

    private lateinit var listaNombresPrincipales : ArrayList<String>
    private lateinit var listaNombresSecundarios : ArrayList<String>

    private var tableroPartidaActual = tipoTableroPrin

    companion object{
        var tableroPrincipalNum = 0
        var tableroSecundarioNum = 0
        lateinit var stageTipoTablero : Stage
        lateinit var guardarTipoTablero: BooleanProperty
        lateinit var guardarTipoTableroSinReiciniar: BooleanProperty
        lateinit var guardarTipoTableroSinReiciniarSecundario: BooleanProperty
    }
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        incializarArrays()
        cargarObservableTipoTablero()
        cargarObservableTipoTableroSinReiniciar()
        cargarObservableTipoTableroSinReiniciarSecundario()
    }

    @FXML
    private fun guardar() {
        if(tableroPrincipalNum >= 2 || tableroPartidaActual >= 2){
            if(partidaEnCurso) {
                if ((tableroPrincipalNum == 2 && tableroPartidaActual == 2) ||
                    (tableroPrincipalNum == 3 && tableroPartidaActual == 3) ||
                    (tableroPrincipalNum == 4 && tableroPartidaActual == 4)){
                    guardarTipoTableroSinReiciniarSecundario.set(true)
                    stageTipoTablero.close()
                }else{
                    mensajeAdvertenciaTT2 = if (tableroPrincipalNum >= 2) {
                        "Si cambias al talbero Memory tu partida actual se reiniciará ya que este tablero aumenta notablemente las mecánicas del juego "
                    } else { "Has empezado una partida con el tablero Memory, si lo cambias esta se reiniciará, ¿estás seguro?" }
                    crearStage(ClaseStage("Vistas/Advertencias/vista_Advertencia_Tipo_Tablero2.fxml", elemento, 370.0, 210.0, null, 0, 0))
                }
            }else{
                if (tableroPrincipalNum >= 2) cPrin.labelModo.text = "Custom"
                else cPrin.labelModo.text = "Clásico"
                guardarTipoTableroSinReiciniar.set(true)
            }
        }else{
            if (!partidaEnCurso) cPrin.labelModo.text = "Clásico"
            guardarTipoTableroSinReiciniar.set(true)
            stageTipoTablero.close()
        }
        if (haGuardadoAdvertencia || !partidaEnCurso || tableroPrincipalNum < 2) ControladorCustomOpciones.haGuardadoTipoTablero = true
    }

    @FXML
    private fun volver() {
        stageTipoTablero.close()
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
        listaPrincipales.add(pMemory)
        listaPrincipales.add(pMemoryX)
        listaPrincipales.add(pMemoryY)


        listaSecundarios.add(sVacio)
        listaSecundarios.add(sClasico)


        listaNombresPrincipales.add("Tablero vacío")
        listaNombresPrincipales.add("Tablero clásico")
        listaNombresPrincipales.add("Tablero Memory")
        listaNombresPrincipales.add("Tablero MemoryX")
        listaNombresPrincipales.add("Tablero MemoryY")


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
        stageTipoTablero = stage!!
    }

    override fun setBoton(b: Button?) {elemento = b!!}
}