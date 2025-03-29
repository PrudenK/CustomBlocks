package com.pruden.tetris_2.Controladores.TusModos

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorTusModos: ControladorGEN(), Initializable {
    lateinit var stageTusModos: Stage


    @FXML lateinit var textoModos: javafx.scene.text.Text
    @FXML lateinit var imgModos: ImageView
    @FXML lateinit var jugar: Button

    var listaNombres = mutableListOf(
        "Modo 1",
        "Modo 2",
        "Modo 3",
        "Modo 4",
        "Modo 5",
        "Modo 6",
        "Modo 7",
        "Modo 8",
        "Modo 9",
    )

    var listaImagenes = mutableListOf(
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

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        indiceActual = 0

        for(modo in jugadorConTodo.listaTusModosDeJuego){
            listaNombres[modo.idnummodo-1] = modo.nombre
            if (!modo.imagen.isNullOrBlank()) {
                listaImagenes[modo.idnummodo-1] = Image("${ConstantesCustomAPI.PATH_CUSTOM}${modo.imagen}")
            }
        }

        when(jugadorConTodo.suscripcionDelJugador!!.tipo){
            1 -> {
                for(i in listaImagenes.indices){
                    if(i >= 3){
                        listaImagenes[i] = deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuegoBloqueado.jpg")
                        listaNombres[i] = "Plan Fit Me ${i-2}"
                        if(i >= 6){
                            listaNombres[i] = "Plan Ultra Mega God  ${i-5}"
                        }
                    }else{
                        if(!jugadorConTodo.listaTusModosDeJuego.map { it.idnummodo }.contains(i+1)){
                            listaImagenes[i] = deRutaAImagen("/Imagenes/ModosDeJuego/AgregarModo.jpg")
                        }
                    }
                }
            }
            2 ->{
                for(i in listaImagenes.indices){
                    if(i >= 6){
                        listaImagenes[i] = deRutaAImagen("/Imagenes/ModosDeJuego/ModoJuegoBloqueado.jpg")
                        listaNombres[i] = "Plan Ultra Mega God  ${i-5}"
                    }else{
                        if(!jugadorConTodo.listaTusModosDeJuego.map { it.idnummodo }.contains(i+1)){
                            listaImagenes[i] = deRutaAImagen("/Imagenes/ModosDeJuego/AgregarModo.jpg")
                        }
                    }
                }
            }
            3->{
                for(i in listaImagenes.indices){
                    if(!jugadorConTodo.listaTusModosDeJuego.map { it.idnummodo }.contains(i+1)){
                        listaImagenes[i] = deRutaAImagen("/Imagenes/ModosDeJuego/AgregarModo.jpg")
                    }
                }
            }
        }


        actualizarUI()
    }

    private var indiceActual = 0

    @FXML fun jugar(){

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
        if((indiceActual > 2 && jugadorConTodo.suscripcionDelJugador!!.tipo == 1)
            || (indiceActual > 5 && jugadorConTodo.suscripcionDelJugador!!.tipo == 2)){
            jugar.text = "Desbloquear"
        }else{
            if(!jugadorConTodo.listaTusModosDeJuego.map { it.idnummodo }.contains(indiceActual+1)){
                jugar.text = "Crear modo"
            }else{
                jugar.text = "Jugar"
            }
        }
    }

    @FXML fun volver() = stageTusModos.close()


    override fun setStage(stage: Stage?) {
        stageTusModos = stage!!
    }

    override fun setBoton(b: Button?) {
    }
}