package com.pruden.tetris_2.Controladores.Partidas

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.ObjsAux.PartidaGuardada
import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Globales.FILAS
import com.pruden.tetris_2.Constantes.Listas.LISTA_VALORES_FILAS_TABLERO
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LINEAS_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.REDUCCION_TIEMPO_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.animacionEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.dashActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcHold
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente1
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente2
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente3
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.holdActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nivelEnJuego
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaHold
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.puedeHoldear
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.rotacionesActuales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.siguientesPiezaActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tiempoCaidaPieza
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoPieza
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
import com.pruden.tetris_2.Controladores.Opciones.ControladorOpciones
import com.pruden.tetris_2.Controladores.Suscripciones.ControladorSuscripciones.Companion.indiceSuscripciones
import com.pruden.tetris_2.Metodos.BolsaPiezas.piezasBolsa
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.DialogoAccion.mostrarDialogoConAccion
import com.pruden.tetris_2.Metodos.DibujarTablero.General.borrarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.paresImparesTableroTipo3y4
import com.pruden.tetris_2.Metodos.DibujarTablero.cambioDeTablero
import com.pruden.tetris_2.Metodos.IniciarPartida.cuentaAtras
import com.pruden.tetris_2.Metodos.IniciarPartida.reiniciarLabels
import com.pruden.tetris_2.Metodos.Matriz.rellenarMatriz
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.cambiarLabelsAlSalirDelModoCampa
import com.pruden.tetris_2.Metodos.PartidasGuardadas.cargarPartidaGuardada
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorPartidasGuardadas: ControladorGEN(), Initializable {
    @FXML lateinit var nombre1: Label
    @FXML lateinit var nombre2: Label
    @FXML lateinit var nombre3: Label

    @FXML lateinit var textoInfo: Label
    @FXML lateinit var titulo: Label
    @FXML lateinit var tituloPaneAux: Label

    @FXML lateinit var cadena1: ImageView
    @FXML lateinit var cadena2: ImageView
    @FXML lateinit var cadena3: ImageView

    @FXML lateinit var imgGuardado1: ImageView
    @FXML lateinit var imgGuardado2: ImageView
    @FXML lateinit var imgGuardado3: ImageView

    @FXML lateinit var eliminar1: ImageView
    @FXML lateinit var eliminar2: ImageView
    @FXML lateinit var eliminar3: ImageView

    @FXML lateinit var pane1: Pane
    @FXML lateinit var paneGuardado: Pane

    companion object{
        lateinit var stagePartidasGuardadas: Stage
        var modo = "Jugar"
    }

    private val nombres = arrayOf("Plan básico", "Plan Fit me", "Plan Ultra Mega")
    private val cadenas = arrayOf(true, true, true)
    private val efectos = arrayOf(true, true, true)
    private val visibles = arrayOf(false, false, false)

    private lateinit var nombreLabels: List<Label>
    private lateinit var cadenasImages: List<ImageView>
    private lateinit var efectosImgs: List<ImageView>
    private lateinit var eliminarBtns: List<ImageView>

    private val imagenHuecoLibre = deRutaAImagen("/Imagenes/Logos/huecoLibre.jpg")

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        nombreLabels = listOf(nombre1, nombre2, nombre3)
        cadenasImages = listOf(cadena1, cadena2, cadena3)
        efectosImgs = listOf(imgGuardado1, imgGuardado2, imgGuardado3)
        eliminarBtns = listOf(eliminar1, eliminar2, eliminar3)

        when(jugadorConTodo!!.suscripcionDelJugador!!.tipo){
            1 -> {
                nombres[0] = "Vacío 1"
                cadenas[0] = false
                efectos[0] = false
                visibles[0] = true
            }
            2 -> {
                nombres[0] = "Vacío 1"; nombres[1] = "Vacío 2"
                cadenas[0] = false; cadenas[1] = false
                efectos[0] = false; efectos[1] = false
                visibles[0] = true; visibles[1] = true
            }
            3 -> {
                nombres[0] = "Vacío 1"; nombres[1] = "Vacío 2"; nombres[2] = "Vacío 3"
                cadenas[0] = false; cadenas[1] = false; cadenas[2] = false
                efectos[0] = false; efectos[1] = false; efectos[2] = false
                visibles[0] = true; visibles[1] = true; visibles[2] = true
            }
        }

        val listaNumsGuardados = jugadorConTodo!!.listaPartidasGuardadas.map { it.numPartidaGuardada }

        for(i in 0..2){
            if(jugadorConTodo!!.suscripcionDelJugador!!.tipo >= i+1){
                if(listaNumsGuardados.contains(i+1)){
                    nombres[i] = "Guardado ${i+1}"
                }else{
                    visibles[i] = false
                    efectosImgs[i].image = imagenHuecoLibre
                }
            }
        }

        for (i in 0..2) {
            nombreLabels[i].text = nombres[i]
            cadenasImages[i].image = if (cadenas[i]) Globales.CADENA else null
            efectosImgs[i].effect = if (efectos[i]) Globales.GRAYSCALE else null
            eliminarBtns[i].isVisible = visibles[i]
        }

        if(modo != "Jugar"){
            textoInfo.text = "Pulsa donde quieres guardar la partida"
            titulo.text = "Guardar partida"
            eliminar1.isVisible = false
            eliminar2.isVisible = false
            eliminar3.isVisible = false
        }
    }

    @FXML fun marco1() = clickEnMarco(0)
    @FXML fun marco2() = clickEnMarco(1)
    @FXML fun marco3() = clickEnMarco(2)

    @FXML fun eliminar1() = dialogoBorrarPartida(1)
    @FXML fun eliminar2() = dialogoBorrarPartida(2)
    @FXML fun eliminar3() = dialogoBorrarPartida(3)

    private fun dialogoBorrarPartida(indice: Int){
        mostrarDialogoConAccion(
            mensaje = "¿Seguro qué quieres borrar la partida?",
            onConfirmar = {
                CoroutineScope(Dispatchers.IO).launch {
                    ApiCustom.partidaGuardadaService.borrarPartida(idJugador, indice)

                    Platform.runLater {
                        jugadorConTodo!!.listaPartidasGuardadas.remove(jugadorConTodo!!.listaPartidasGuardadas.find { it.numPartidaGuardada == indice })
                        nombreLabels[indice-1].text = "Vacío $indice"
                        eliminarBtns[indice-1].isVisible = false
                        efectosImgs[indice-1].image = imagenHuecoLibre
                    }
                }
            }
        )
    }


    private fun clickEnMarco(marco: Int){
        if(jugadorConTodo!!.suscripcionDelJugador!!.tipo < marco+1){
            indiceSuscripciones = marco
            crearStage(Stages.SUSCRIPCIONES)
            stagePartidasGuardadas.close()
        }else{
            if(modo == "Jugar"){
                if(nombreLabels[marco].text.startsWith("Guardado ")){
                    mostrarDialogoConAccion(
                        mensaje = "¿Cargar partida ${marco+1}?",
                        onConfirmar = {
                            CoroutineScope(Dispatchers.IO).launch {
                                val partida = jugadorConTodo!!.listaPartidasGuardadas.find { it.numPartidaGuardada == marco +1 }!!
                                jugadorConTodo!!.listaPartidasGuardadas.remove(partida)

                                ApiCustom.partidaGuardadaService.borrarPartida(idJugador, marco+1)
                                Platform.runLater {
                                    cronometro.parar()
                                    cambiarLabelsAlSalirDelModoCampa()

                                    stagePartidasGuardadas.hide()
                                    cPrin.canvasPrincipal.isVisible = false
                                    borrarTableroSecundario(gcSiguiente1)
                                    borrarTableroSecundario(gcSiguiente2)
                                    borrarTableroSecundario(gcSiguiente3)
                                    borrarTableroSecundario(gcHold)
                                    cPrin.labelModo.text = ""
                                    cPrin.labelModoEstatico.isVisible = false

                                    ControladorOpciones.stageOpciones.close()
                                    reiniciarLabels()
                                    cronometro.seTCronometroA0()
                                    cuentaAtras()
                                }
                                delay(3000)
                                Platform.runLater {
                                    animacionEnCurso = false
                                    cPrin.canvasPrincipal.opacity = 1.0
                                    cPrin.canvasPrincipal.isVisible = true
                                    cPrin.labelModoEstatico.isVisible = true
                                    cargarPartidaGuardada(partida)
                                }
                            }
                        }
                    )
                }
            }else{
                if(partidaEnCurso){
                    if(!nivelEnJuego){
                        if(nombreLabels[marco].text.startsWith("Vacío ")){
                            guardarPartida(marco+1)
                            ajustarPaneTrasGuardar("¡Partida guardada!")

                            Platform.runLater {
                                partidaEnCurso = false
                                cronometro.seTCronometroA0()
                                cronometro.parar()
                                timelinePartida.stop()

                                if(piezaHold.isNotEmpty()){
                                    piezaHold.removeAt(0)
                                }
                                piezasBolsa.clear()

                                cambioDeTablero()

                                reiniciarLabels()


                                borrarTableroSecundario(gcHold)
                                borrarTableroSecundario(gcSiguiente1)
                                borrarTableroSecundario(gcSiguiente2)
                                borrarTableroSecundario(gcSiguiente3)

                            }


                        }else{
                            mostrarDialogoConAccion(
                                mensaje = "¿Quieres remplazar el guardado ${marco+1}?",
                                onConfirmar = {
                                    CoroutineScope(Dispatchers.IO).launch {
                                        ApiCustom.partidaGuardadaService.borrarPartida(idJugador, marco +1)
                                        guardarPartida(marco+1)
                                        ajustarPaneTrasGuardar("¡Partida guardada!")
                                    }
                                }
                            )
                        }
                    }else ajustarPaneTrasGuardar("No puedes guardar en modo campaña")
                }else{
                    ajustarPaneTrasGuardar("No hay partida en curso")
                }
            }
        }
    }

    @FXML fun volver() = stagePartidasGuardadas.close()


    private fun guardarPartida(indicePartidaGuardada: Int){

        var piezaHoldS = ""
        if(piezaHold.size == 1){
            piezaHoldS = piezaHold[0].javaClass.toString().replace("class com.pruden.tetris_2.Piezas.Pieza_", "")
        }

        piezaActual.limpiar()

        val partida = PartidaGuardada(
            idJugador = jugadorConTodo!!.id,
            numPartidaGuardada = indicePartidaGuardada,
            modo = cPrin.labelModo.text.toString(),
            tiempo = cPrin.cronometroLabel.text.toString(),
            puntuacion = cPrin.labelPuntuacion.text.toInt(),
            lineas = cPrin.labelLineas.text.toInt(),
            nivel = cPrin.labelNivel.text.toInt(),
            tableroPartida = matrizNumerica.map { it.toList() },
            tamaTablero = LISTA_VALORES_FILAS_TABLERO.indexOf(FILAS),
            diseTablero = tipoTableroPrin,
            diseTableroSecun = tipoTableroSecun,
            siguientesPiezasActivo = if (siguientesPiezaActivo) 1 else 0,
            siguientesPiezas = siguientePieza.map { it.javaClass.toString()
                .replace("class com.pruden.tetris_2.Piezas.Pieza_", "") }
                .toString().replace("[", "").replace("]", "")
                .replace(" ",""),
            arrayPiezas = codificarPiezasSeleccionadas(listaPiezasSeleccionadas),
            disePiezas = tipoPieza,
            holdActivo = if (holdActivo) 1 else 0,
            dashActivo = if (dashActivo) 1 else 0,
            piezaEnHold = piezaHoldS,
            puedeHoldear = if (puedeHoldear) 1 else 0,
            velocidadCaidaActual = tiempoCaidaPieza,
            lineasParaSaltoDeNivel = LINEAS_POR_NIVEL,
            saltoDeTiempoPorNivel = REDUCCION_TIEMPO_POR_NIVEL,
            limiteRotaciones = if(LIMITE_ROTACIONES == 999999999) -1 else LIMITE_ROTACIONES,
            piezaActual = piezaActual.javaClass.toString().replace("class com.pruden.tetris_2.Piezas.Pieza_", ""),
            posicionPiezaActual = "${piezaActual.getFilaCentro()}_${piezaActual.getColumnaCentro()}_${piezaActual.orientacion}",
            numRotacionesDeLaPiezaActual = rotacionesActuales,
            estadoMascara = paresImparesTableroTipo3y4
        )

        CoroutineScope(Dispatchers.IO).launch {
            val response = ApiCustom.partidaGuardadaService.guardarPartida(partida)
            when(response.code()){
                200 ->{
                    jugadorConTodo!!.listaPartidasGuardadas = response.body()!!
                }
            }
            println(response)
        }
    }

    private fun codificarPiezasSeleccionadas(lista: List<Boolean>): String {
        val resultado = lista.mapIndexedNotNull { index, seleccionada ->
            if (seleccionada) index else null
        }.joinToString("_")
        return if(resultado == "") "0_1_2_3_4_5_6" else resultado
    }

    private fun ajustarPaneTrasGuardar(texto : String){
        pane1.isVisible = false
        paneGuardado.isVisible = true
        tituloPaneAux.text = texto

        stagePartidasGuardadas.height = paneGuardado.height
        stagePartidasGuardadas.width = paneGuardado.width

        val parentStage = cPrin.nuevaPartidaB.scene.window as Stage

        val parentX = parentStage.x
        val parentY = parentStage.y
        val parentWidth = parentStage.width
        val parentHeight = parentStage.height

        val newWidth = stagePartidasGuardadas.width
        val newHeight = stagePartidasGuardadas.height

        stagePartidasGuardadas.x = parentX + (parentWidth - newWidth) / 2
        stagePartidasGuardadas.y = (parentY + (parentHeight - newHeight) / 2) -60
    }

    override fun setStage(stage: Stage?) {
        stagePartidasGuardadas = stage!!
    }

    override fun setBoton(b: Button?) {

    }
}