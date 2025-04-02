package com.pruden.tetris_2.Controladores.ModosDeJuego.TusModos

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Controladores.ModosDeJuego.ControladorMenuModos
import com.pruden.tetris_2.Controladores.Suscripciones.ControladorSuscripciones
import com.pruden.tetris_2.Metodos.DialogoAccion.mostrarDialogoConAccion
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.ModosDeJuego.TusModos.cargarCambiosTusModos
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorTusModos: ControladorGEN(), Initializable {
    @FXML lateinit var textoModos: javafx.scene.text.Text
    @FXML lateinit var imgModos: ImageView
    @FXML lateinit var imgBorrar: ImageView
    @FXML lateinit var jugar: Button

    private var listaNombres = mutableListOf(
        "Modo 1", "Modo 2", "Modo 3",
        "Modo 4", "Modo 5", "Modo 6",
        "Modo 7", "Modo 8", "Modo 9",
    )

    private var listaImagenes = mutableListOf(
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego1.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego2.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego3.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego4.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego5.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego6.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego7.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego8.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuego9.jpg"),
    )

    companion object{
        lateinit var stageTusModos: Stage
        var indiceActual = 0
    }

    private val AGREGAR_MODO = deRutaAImagen("/Imagenes/ModosDeJuego/AgregarModo.jpg")
    private val BLOQUEADO = deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuegoBloqueado.jpg")

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        indiceActual = 0

        for(modo in jugadorConTodo!!.listaTusModosDeJuego){
            listaNombres[modo.idnummodo-1] = modo.nombre
            if (!modo.imagen.isNullOrBlank()) {
                listaImagenes[modo.idnummodo-1] = Image("${ConstantesCustomAPI.PATH_CUSTOM}${modo.imagen}")
            }
        }

        when(jugadorConTodo!!.suscripcionDelJugador!!.tipo){
            1 -> {
                for(i in listaImagenes.indices){
                    if(i >= 3){
                        listaImagenes[i] = BLOQUEADO
                        listaNombres[i] = "Plan Fit Me ${i-2}"
                        if(i >= 6){
                            listaNombres[i] = "Plan Ultra Mega ${i-5}"
                        }
                    }else{
                        if(!jugadorConTodo!!.listaTusModosDeJuego.map { it.idnummodo }.contains(i+1)){
                            listaImagenes[i] = AGREGAR_MODO
                        }
                    }
                }
            }
            2 ->{
                for(i in listaImagenes.indices){
                    if(i >= 6){
                        listaImagenes[i] = BLOQUEADO
                        listaNombres[i] = "Plan Ultra Mega ${i-5}"
                    }else{
                        if(!jugadorConTodo!!.listaTusModosDeJuego.map { it.idnummodo }.contains(i+1)){
                            listaImagenes[i] = AGREGAR_MODO
                        }
                    }
                }
            }
            3->{
                for(i in listaImagenes.indices){
                    if(!jugadorConTodo!!.listaTusModosDeJuego.map { it.idnummodo }.contains(i+1)){
                        listaImagenes[i] = AGREGAR_MODO
                    }
                }
            }
        }

        actualizarUI()
    }


    @FXML fun jugar(){
        when(jugar.text){
            "Jugar" ->{
                cargarCambiosTusModos(jugadorConTodo!!.listaTusModosDeJuego.find { it.idnummodo == indiceActual +1 }!!)
                stageTusModos.close()
            }
            "Crear modo"->{
                crearStage(Stages.CREAR_MODO)
            }
            "Desbloquear"->{
                val indiceSus = (indiceActual / 3.0).toInt()
                ControladorSuscripciones.indiceSuscripciones = indiceSus
                ControladorSuscripciones.seAbreDesdeTusModos = true
                crearStage(Stages.SUSCRIPCIONES, stageTusModos)
            }
        }
    }

    @FXML fun atras(){
        if(indiceActual == 0){
            indiceActual = listaImagenes.size -1
        }else indiceActual--
        actualizarUI()
    }

    @FXML fun siguiente(){
        if(indiceActual == listaImagenes.size -1){
            indiceActual = 0
        }else indiceActual++
        actualizarUI()
    }

    private fun actualizarUI(){
        imgModos.image = listaImagenes[indiceActual]
        textoModos.text = listaNombres[indiceActual]
        if((indiceActual > 2 && jugadorConTodo!!.suscripcionDelJugador!!.tipo == 1)
            || (indiceActual > 5 && jugadorConTodo!!.suscripcionDelJugador!!.tipo == 2)){
            jugar.text = "Desbloquear"
            imgBorrar.isVisible = false
        }else{
            if(!jugadorConTodo!!.listaTusModosDeJuego.map { it.idnummodo }.contains(indiceActual+1)){
                jugar.text = "Crear modo"
                imgBorrar.isVisible = false
            }else{
                jugar.text = "Jugar"
                imgBorrar.isVisible = true
            }
        }
    }

    @FXML fun volver(){
        stageTusModos.close()
        ControladorMenuModos.cMenuModos.stageMenuMundos.show()
    }

    @FXML fun borrarModo(){
        println(indiceActual)
        mostrarDialogoConAccion(
            "¿Quieres borrar el modo de juego?",
            onConfirmar = {
                CoroutineScope(Dispatchers.IO).launch {
                    val modo = jugadorConTodo!!.listaTusModosDeJuego.find { it.idnummodo == indiceActual+1 }!!

                    println(modo.idnummodo)
                    println(jugadorConTodo!!.id)

                    ApiCustom.modoDeJuegoService.borrarModoDeJuego(jugadorConTodo!!.id, modo.idnummodo)
                    jugadorConTodo!!.listaTusModosDeJuego.remove(modo)

                    Platform.runLater {
                        listaImagenes[indiceActual] = AGREGAR_MODO
                        listaNombres[indiceActual] = Listas.LISTA_CONSTANTE_DE_NOMBRES_MODOS_DE_JUEGO[indiceActual]
                        actualizarUI()
                    }
                }
            }
        )
    }


    override fun setStage(stage: Stage?) {
        stageTusModos = stage!!
    }

    override fun setBoton(b: Button?) {
    }
}